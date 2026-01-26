package example

interface Movable{
    var speed: Int
    var model:String
    var number: String
    fun move()
    fun stop(){
        println("Stoping")
    }
}
class Car(
    override var model:String,
    override var number: String
) : Movable{
    override var speed = 60
    override fun move() {
        println("Driving in a car at $speed km/h")
    }
}
class Aircraft(
    override var model:String,
    override var number: String
) : Movable{
    override var speed = 600
    override fun move() {
        println("Flying in a plane at $speed km/h")
    }
    override fun stop() = println("Landing...")
}
fun travel(obj: Movable) = obj.move()

interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name: String): Worker, Student{
    override fun work() = println("$name is working")
    override fun study() = println("$name is learning")
}
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer: VideoPlayable, AudioPlayable{
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
fun main(){
    val player = MediaPlayer()
    player.play()

    val anton = WorkingStudent("Anton")
    anton.work()
    anton.study()

    val car: Movable = Car("Lada", "134LAD")
    car.move()
    car.stop()
    val aircraft: Movable = Aircraft("Boeing", "737")
    aircraft.move()
    aircraft.stop()
}
