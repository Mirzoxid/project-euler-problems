package problems

fun solution34(){
    var summ = 0
    for (i in 10..99999999){
        if (i == factSumm(i)){
            summ += i
        }
    }
    println(summ)
}

fun factSumm(num: Int): Int{
    var n = num
    var s = 0
    while (n>0){
        var p = 1
        for (i in 1..n%10){
            p *= i
        }
        s+= p
        n /= 10
    }
    return s
}
