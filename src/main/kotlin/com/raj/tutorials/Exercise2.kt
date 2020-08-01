import java.math.BigDecimal

data class Seat(val row: Int, val num: Int, val price: BigDecimal, val description: String) {
	//YOU MAY NOT EDIT THIS CLASS!
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}

class Theater {

   // SEAT PRICES:
   // Seats in rows 14 and 15 cost 14.50
   // Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
   // All other seats in row 1 cost 21.00
   // All other seats cost 18.00
   
   // SEAT DESCRIPTIONS:
   // Seats in row 15: "Back row"
   // Seats in row 14: "Cheaper seat"
   // All other rows, seats 1 to 3 and 34 to 36: "Restricted View"
   // All other seats in rows 1 and 2 "Best view"
   // All other seats: "Standard seat"

	val seats
        get() = hiddenSeats.toList()

    private val hiddenSeats = mutableListOf<Seat>()

/*    constructor() {
        // Seats in rows 14 and 15 cost 14.50
        (1..15).forEach { rowIndex -> (14..15).forEach { seatIndexOfRow->  hiddenSeats.add(Seat(rowIndex,seatIndexOfRow, BigDecimal(14.50),"cheaper seat"))} }
        // Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
        (1..13).forEach { rowIndex -> (1..3).forEach { seatIndexOfRow->  hiddenSeats.add(Seat(rowIndex,seatIndexOfRow, BigDecimal(16.50),"restricted view"))} }
        (1..13).forEach { rowIndex -> (34..36).forEach { seatIndexOfRow->  hiddenSeats.add(Seat(rowIndex,seatIndexOfRow, BigDecimal(16.50),"restricted view"))} }
        //All other seats in row 1 cost 21.00
        (4..33).forEach { seatIndexInFirstRow ->
            run {
                if (seatIndexInFirstRow != 14 || seatIndexInFirstRow != 15) {
                    hiddenSeats.add(Seat(1, seatIndexInFirstRow, BigDecimal(16.50), "best view"))
                }
            }
        }
        // All other seats cost 18.00
        (2..15).forEach { rowIndex -> (14..15).forEach { seatIndexOfRow->
            if (seatIndexOfRow != 14 || seatIndexOfRow != 15) {
                hiddenSeats.add(Seat(1, seatIndexOfRow, BigDecimal(16.50), "standard seat"))
            }
        }
        }
    }*/

    constructor() {
        fun getPrice(row: Int, num: Int): BigDecimal {
            return when {
                row>=14 -> BigDecimal(14.50)
                num <=3 || num >=34 -> BigDecimal(16.50)
                row ==1 -> BigDecimal(21)
                else -> BigDecimal(18)
            }
        }
        fun getDescription(row: Int, num: Int): String {
            return when {
                row == 15 -> "Back Row"
                row == 14 -> "Cheaper Seat"
                num <=3 || num >=34 -> "Restricted View"
                row <=2 -> "Best View"
                else -> "Standard Seat"
            }
        }
        for (row in 1..15) {
            for (num in 1..36) {
                hiddenSeats.add(Seat(row, num, getPrice(row,num),getDescription(row, num)))
            }
        }
    }



}

fun main(args: Array<String>) {
    val cheapSeats = Theater().seats.filter {it.price == BigDecimal(14.50)}
    for (seat in cheapSeats) println (seat)
}