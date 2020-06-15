package problems

fun problem25() {
    print(generateFibNums(1000).size)
}

fun generateFibNums(fibLIdx: Int): MutableList<MutableList<Int>> {
    val arr: MutableList<MutableList<Int>> = mutableListOf()
    var index = 0
    var digits = 0
    while (digits<fibLIdx) {
        if (index < 2) {
            arr.add(mutableListOf(1))
            index++
            continue
        }
        val itArr = cloneArr(arr[index - 1])
        var d = 0
        for ((itIdx, _) in arr[index - 1].withIndex()) {
            if (arr[index - 2].size > itIdx) {
                var n = itArr[itIdx] + arr[index - 2][itIdx]
                d = n / 10
                n %= 10
                itArr[itIdx] = n
            }
            var wI = itIdx + 1
            while (d>0){
                if (arr[index - 1].size > wI) {
                    var n = itArr[wI] + d
                    d = n / 10
                    n %= 10
                    itArr[wI] = n
                } else {
                    itArr.add(d)
                    d = 0
                }
                wI++
            }
        }
        arr.add(itArr)
        digits = itArr.size
        index++
    }
    return arr
}

fun cloneArr(mutableList: MutableList<Int>): MutableList<Int> {
    val arr : MutableList<Int> = mutableListOf()
    for (it in mutableList){
        arr.add(it)
    }
    return arr
}
