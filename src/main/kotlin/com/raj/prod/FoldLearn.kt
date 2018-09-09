package com.raj.prod

//Add the total quantity in a list

data class Product(val name: String, val quantity: Int) {}

fun main(asa: Array<String>) {

    val total = listOf(1,2,3,4,5).fold(0, {acc,b -> acc +b})
    println("total is $total")

    val mul = listOf<Int>(1,2,3,4,5).fold(1 , {acc, b -> acc*b} )
    println("multiplication is $mul")

    val productList = listOf<Product> (
            Product("A",1),
            Product("B",2),
            Product("C",3),
            Product("D",4),
            Product("E",5)
    )
    val quantity = productList.fold(0, {acc, product -> acc+ product.quantity})
    println("quantity is $quantity")

    val quantity1 = productList.foldRight(0) {product, acc -> acc+ product.quantity  }
    println("quantity1 is $quantity1")

    val quantityFoldRight = listOf<String>("1","2","3").foldRight("X"){str, acc-> acc +str }
    val quantityFoldLeft = listOf<String>("1","2","3").fold("X"){acc, str-> acc +str }


    println("learn foldRight is $quantityFoldRight and learn foldLeft is $quantityFoldLeft")

}
