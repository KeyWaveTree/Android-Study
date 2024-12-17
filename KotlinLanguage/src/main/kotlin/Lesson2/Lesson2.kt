package Lesson2

import kotlin.math.abs
import kotlin.math.sqrt

// typealias 일종의 c언어의 구조체와 비슷함.
//list<list<Int>>incombinient 할 수 있다.
typealias Point = List<Int>
typealias PointList = List<Point>
//(x좌표, y 좌표 )
val point:(Int, Int) -> List<Int> = {a,b -> listOf(a, b) }
val default_func = {points: PointList -> points}

//higher function
// define process as a named function
//takes the point list and a processor function as the arguments,
//o applies the function on the points,
//o and prints the results.
            //파라미터          람다식의(파라미터 자료형) -> return 할 형태 = 기본적으로 받지 않으면 default_func으로 인자를 받아라
fun process(points: PointList, lambda:(PointList) -> Any = default_func) //포인트, 람다함수
{
    println(lambda(points))
}

// define filterLeft as a named function
fun filterLeft(points: PointList): PointList
{
    return points.filter {it[0]<0}
}

// define norm as a lambda function
val norm:(Point)->Double = { point -> sqrt((point[0] * point[0]+ point[1] * point[1]).toDouble()) }

// define normAll as a lambda function
val normAll = {points: PointList -> points.map(norm)}

// define normLessThanTwo as a lambda function
val normLessThanTwo = {points: PointList -> points.filter{ norm(it) <= 2}}

// define flipX as a named function
fun flipX(points: PointList): PointList
{
    return points.map { listOf(it[0] * -1, it[0]) }
}

//x가 음수일때 flip해라
fun negativeFlipX(points: PointList) : PointList
{
   return points.map { listOf(abs(it[0]), it[1]) }
}

fun main()
{
    val points = listOf(point(1, 2), point(-2, 3), point(-1, 0), point(2, 1))
    print("original points: \t")
    process(points)
    print("left points: \t")
    process(points, lambda =::filterLeft) // complete the call
    print("norms: \t")
    process(points, normAll) // complete the call
    print("norm<2: \t")
    process(points, normLessThanTwo) // complete the call
    print("flip_x: \t")
    process(points, lambda =::flipX)
    print("Flip the left points -> right side:\t")
    process(points, lambda = ::negativeFlipX)
}