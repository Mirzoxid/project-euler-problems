package problems

fun solution50(){
    val arr = mutableListOf<Int>()
    val arr2 = mutableListOf<Int>()
    var kk = 100
    for (i in 2..1000000){
        if (isTub(i)){
            if (arr.size == 0){
                arr.add(i)
            } else {
                arr.add(arr[arr.size - 2])
            }

        }
    }
}
