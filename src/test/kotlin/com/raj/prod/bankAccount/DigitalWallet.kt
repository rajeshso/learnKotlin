package com.raj.prod.bankAccount

import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.util.concurrent.locks.ReentrantLock
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

/**
 * The Digital Wallet should be implemented in Kotlin, and you should use functional programming principles to organize your code.
 *
 * The wallet should be able to create user accounts, deposit and withdraw funds, and transfer funds between accounts.
 *
 * Each user account should have a unique identifier, such as an account number or username, and should store the user's balance.
 *
 * The Digital Wallet should validate user input and ensure that users cannot transfer more funds than they have available in their account.
 *
 * When a user transfers funds, the Digital Wallet should update the account balances for both the sender and the recipient.
 *
 * You should write unit tests to ensure that your code works as expected.
 */
class DigitalWallet {
    val accounts = mutableMapOf<Int, Account>()

    val reentrantLock = ReentrantLock()

    fun create(): Int {
        val newAccountId = accounts.keys.maxOrNull()?.plus(1) ?: 1
        accounts[newAccountId] = Account(newAccountId)
        return newAccountId
    }

    fun deposit(accountId: Int, amount: BigDecimal): Unit {
        val account = accounts[accountId]
        if (validAccount(account)) {
            reentrantLock.lock()
            try {
                account!!.balance+=amount
                println("Deposit of ${amount} is successful for $accountId and the new balance is ${account!!.balance} ")
            } finally {
                reentrantLock.unlock()
            }
        }else {
            println("$accountId does not exist")
            throw IllegalArgumentException(("$accountId does not exist"))
        }
    }

    private fun validAccount(account: Account?) = account != null

    fun withdraw(accountId: Int, amount: BigDecimal): Unit {
        val account = accounts[accountId]
        if (invalidAccount(account)) {
            println("$accountId does not exist")
            throw IllegalArgumentException(("$accountId does not exist"))
        }else if (insufficientBalance(account!!, amount)) {
            println("Insufficient balance - Withdrawal of ${amount} is not successful for $accountId because the current balance is ${account.balance} lesser than $amount ")
            throw IllegalArgumentException(("Insufficient balance - Withdrawal of ${amount} is not successful for $accountId because the current balance is ${account.balance} lesser than $amount "))
        } else if (sufficientBalance(account, amount)) {
            reentrantLock.lock()
            try {
                if (sufficientBalance(account, amount)) {
                    account.balance -= amount
                    println("Withdrawal of ${amount} is successful for $accountId and the new balance is ${account.balance} ")
                }
            } finally {
                reentrantLock.unlock()
            }
        }
    }

    fun transfer(fromAccountId: Int, toAccountId: Int, amount: BigDecimal) {
        val accountSource = accounts[fromAccountId]
        val accountDestination = accounts[toAccountId]
        if (invalidAccount(accountSource) || invalidAccount(accountDestination)) {
            println("$fromAccountId or $toAccountId does not exist")
            throw IllegalArgumentException(("$fromAccountId or $toAccountId does not exist"))
        } else if (insufficientBalance(accountSource!!, amount)) {
            println("Insufficient balance - Withdrawal of ${amount} is not successful for $accountSource because the current balance is ${accountSource.balance} lesser than $amount ")
            throw IllegalArgumentException(("Insufficient balance - Withdrawal of ${amount} is not successful for $accountSource because the current balance is ${accountSource.balance} lesser than $amount "))
        } else if (sufficientBalance(accountSource, amount)) {
            reentrantLock.lock()
            try {
                if (sufficientBalance(accountSource, amount)) {
                    accountSource.balance -= amount
                    accountDestination!!.balance += amount
                    println("Transfer of $amount is successful from $fromAccountId to $toAccountId and the new balance for $fromAccountId is ${accountSource.balance} and for $toAccountId is ${accountDestination!!.balance} ")
                }
            } finally {
                reentrantLock.unlock()
            }
        }
    }

    private fun invalidAccount(account: Account?) = account == null

    private fun sufficientBalance(
        account: Account,
        amount: BigDecimal
    ) = account.balance > amount

    private fun insufficientBalance(
        accountSource: Account,
        amount: BigDecimal
    ) = accountSource.balance < amount

    @Test
    fun createAccountShouldAddAnAccountToMap(): Unit {
        val accountId = create()
        assertContains(accounts, accountId,"$accountId is not created")
        assertEquals(BigDecimal.ZERO, accounts.get(accountId)?.balance)
    }
    @Test
    fun createTwoAccountShouldAddAnAccountToMap(): Unit {
        val accountId1 = create()
        assertContains(accounts, accountId1,"$accountId1 is not created")
        assertEquals(BigDecimal.ZERO, accounts.get(accountId1)?.balance)

        val accountId2 = create()
        assertContains(accounts, accountId2,"$accountId2 is not created")
        assertEquals(BigDecimal.ZERO, accounts.get(accountId2)?.balance)

        assertEquals(2, accounts.size)
    }

    @Test
    fun depositToNonExistentAccountShouldThrowException(): Unit {
        assertThrows<IllegalArgumentException> {
            deposit(12121, BigDecimal.TEN)
        }
    }

    @Test
    fun depositToAccountShouldInitialiseBalance() {
        val accountId = create()
        deposit(accountId, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN, accounts.get(accountId)?.balance)
    }
    @Test
    fun depositToAccountShouldIncrementBalance() {
        val accountId = create()
        deposit(accountId, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN, accounts.get(accountId)?.balance)

        deposit(accountId, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN.plus(BigDecimal.TEN), accounts.get(accountId)?.balance)
    }
    @Test
    fun withdrawFromAccountShouldReduceBalance() {
        val accountId = create()
        deposit(accountId, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN, accounts.get(accountId)?.balance)

        withdraw(accountId, BigDecimal.ONE)
        assertEquals(BigDecimal(9), accounts.get(accountId)?.balance)
    }
    @Test
    fun withdrawFromAccountShouldThrowInsuffientBalance() {
        val accountId = create()
        deposit(accountId, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN, accounts.get(accountId)?.balance)

        assertThrows<IllegalArgumentException> {
            withdraw(accountId, BigDecimal.TEN.plus(BigDecimal.TEN))
        }
    }

    @Test
    fun transferShouldAddAndReduceAmounts(): Unit {
        val accountIdSource = create()
        val accountIdDestination = create()
        deposit(accountIdSource, BigDecimal.TEN)
        deposit(accountIdDestination, BigDecimal.TEN)
        assertEquals(BigDecimal.TEN, accounts.get(accountIdSource)?.balance)
        assertEquals(BigDecimal.TEN, accounts.get(accountIdDestination)?.balance)

        //transfer
        transfer(accountIdSource, accountIdDestination, BigDecimal.ONE)
        assertEquals(BigDecimal.TEN.minus(BigDecimal.ONE), accounts[accountIdSource]?.balance)
        assertEquals(BigDecimal.TEN.plus(BigDecimal.ONE), accounts[accountIdDestination]?.balance)
    }
}