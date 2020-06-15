package problems

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * */

const val starYear = 1900
const val startWeekDay = 1
val weekDays = hashMapOf(0 to "sunday", 1 to "monday", 2 to "tuesday", 3 to "wednesday", 4 to "thursday", 5 to "friday", 6 to "saturday")

fun main() {
    var summ = 0
    for (i in 1901..2000) {
        for (j in 1..12) {
            if (weekDays[(getAllDays(j, i) - getDaysInMonth(j, i)+1)%7] == "sunday")
                summ++
        }
    }
    println(summ)
}

fun getAllDays(month: Int, year: Int): Int {
    var summ = 0
    for (i in 1900..year) {
        summ += if (year != i) getDaysInYear(12, i) else getDaysInYear(month, i)
    }
    return summ
}

fun getDaysInYear(month: Int, year: Int): Int {
    var summ = 0
    for (i in 1..month) {
        summ += getDaysInMonth(i, year)
    }
    return summ
}

fun getDaysInMonth(month: Int, year: Int): Int {
    return when (month) {
        4, 6, 9, 11 -> 30
        2 -> if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0) 28 else 29
        1, 3, 5, 7, 8, 10, 12 -> 31
        else -> 0
    }
}
