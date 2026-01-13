var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 1111))
            field = value
    }
fun main(){
    println(age)
    age =45
    println(age)
    age = -1000
    println(age)
}