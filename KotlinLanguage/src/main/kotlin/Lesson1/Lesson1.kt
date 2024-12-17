package Lesson1

fun main(args: Array<String>)
{
    // take input of number of students
    // 읽을때 입력 안해도 입력을 해도 다 값을 받고 입력값이 int로 변환 할 수 있다면 변환
    // 변환 할 수 없다면 0으로 값을 전달해라

    print("Enter the total number of students:")
    val numOfStudents: Int = readlnOrNull()?.toIntOrNull() ?: 0

    // initialize the id and score arrays
    val idArray = arrayOfNulls<Long>(numOfStudents)//배열도 null과 long형을 담을 수 있다.
    val scoreArray = arrayOfNulls<Int>(numOfStudents)// 위 코드와 마찬가지

    // take input for each student
    //0에서 부터 입력한 학생의 수 전까지 반복하라
    for (i in 0..< numOfStudents)
    {
        println("$i-th Student")
        print("Enter ID:")
        idArray[i] = readlnOrNull()?.toLongOrNull()

        print("Enter Score:")
        //입력을 할때 값을 null로 받을 수 있는데 숫자로 해석할 수 있다면 int값으로 아니면 null로 담아라
        scoreArray[i] = readlnOrNull()?.toIntOrNull()
    }

    //여기에서부터 값을 처리하자. 활용할 주석 활용

    // find the average score
    var sum: Int = 0
    for (score in scoreArray)
    {
        //만약 score가 unit일때 continue
        if(score == null) continue;
        sum += score;
    }

    val avgScore = sum.toFloat() / scoreArray.filterNotNull().size
    // find the highest and lowest score

    val highIndex:Int = scoreArray.indexOf(scoreArray.filterNotNull().maxOrNull())
    val lowIndex :Int = scoreArray.indexOf(scoreArray.filterNotNull().minOrNull())

    val highestScore = if(scoreArray[highIndex] ==null) "Unknown" else scoreArray[highIndex]
    val lowestScore = if(scoreArray[lowIndex] ==null) "Unknown" else scoreArray[lowIndex]

    val highestId = if(idArray[highIndex] == null) "Unknown" else idArray[highIndex]
    val lowestId = if(idArray[lowIndex] == null) "Unknown" else idArray[lowIndex]


    // final output
    println("Avg. score:$avgScore")
    println("Highest score -> ID: $highestId \t Score: $highestScore")
    println("Lowest score -> ID: $lowestId \t Score: $lowestScore")
}
