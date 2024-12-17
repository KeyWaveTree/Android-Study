package Lesson3

interface MyNumber<T>{
    var a: Double
    var b: Double
    fun add(x: T): T
    fun neg(x: T): T
    fun sub(x: T): T = add(neg(x))
    operator fun plus(x: T): T = add(x)
    operator fun minus(x: T): T = sub(x)
}

class Complex(override var a: Double, override var b: Double):MyNumber<Complex>
{

    constructor( one : Int,  two : Int): this(one.toDouble(), two.toDouble()){}
    override fun add(x: Complex): Complex
    {
        return Complex(a + x.a, b + x.b)
    }

    override fun neg(x: Complex): Complex
    {
        return Complex(a - x.a, b - x.b)
    }

    operator fun plus(x: Exponent): Complex
    {
        return Complex(Math.pow(x.a, x.b) + a, b)
    }

    override fun toString(): String
    {
        return "$a + ${b}i"
    }

}

class Exponent(override var a: Double, override var b: Double):MyNumber<Exponent>
{

    constructor( one : Int,  two : Int): this(one.toDouble(), two.toDouble()) {}

    override fun add(x: Exponent): Exponent
    {
        return Exponent(Math.pow(a, b) + Math.pow(x.a, x.b), 1.0)
    }

    override fun neg(x: Exponent): Exponent
    {
        return Exponent(Math.pow(a, b) - Math.pow(x.a, x.b), 1.0)
    }

    operator fun plus(x: Complex): Complex
    {
        return  Complex(Math.pow(a, b) + x.a, x.b)
    }
    override fun toString(): String
    {
        return "$a"
    }
}

fun main()
{
    val c1 = Complex(4,2)
    val c2 = Complex(1,2)
    println(c1+c2)
    println(c1-c2)
    val e1 = Exponent(2,3)
    val e2 = Exponent(1,2)
    println(e1+e2)
    println(e1-e2)
    println(c1 + e1)
    println(e1 + c1)

}

/*
    5.0 + 4.0i
    7.0 + 2.0i
    9.0
    15.0
    12.0 + 2.0i
    12.0 + 2.0i
*/