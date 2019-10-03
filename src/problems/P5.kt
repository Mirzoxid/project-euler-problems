package problems

/**
 * 2520 - har bir qoldiqsiz 1 dan 10 gacha bo'lgan raqamlarning har biriga bo'linishi mumkin bo'lgan eng kichik raqam.
 *
 * 1 dan 20 gacha bo'lgan barcha sonlarga teng bo'linadigan eng kichik musbat son qanday?
 * */
fun main() {
    val mainNum = 20
    val res = minMult(mainNum)
    println(res)
}

fun minMult(mainNum: Int): Int {
    val tbKop = mutableListOf<ArrayList<Int>>()
    for (i in 2..mainNum) {
        tbKop.add(tubMult(i))
    }
    return evRes(tbKop)
}

fun tubMult(a: Int): ArrayList<Int> {
    var i = 2
    var tmp = a
    val tuMArr = arrayListOf<Int>()
    while ( tmp >= i) {
        if (tmp % i == 0){
            tmp /= i
            tuMArr.add(i)
        } else {
            i++
        }
    }
    return tuMArr
}

fun evRes(list: MutableList<ArrayList<Int>>): Int{
    var res = 1
    for (a in list){
        var onceMult = 1
        for (b in a){
            onceMult *= b
            if (res % onceMult != 0){
                res *= b
            }
        }
    }
    return res
}
