package characters

class OutpostWorker(val name: String) {
    var maxEnergy: Int = 100
        private set
    var energy: Int = maxEnergy
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }
    var mood: Int = 50
        get() = field + (energy / 10)

    var level: Int = 1
        private set

    fun work() {
        println("$name is working")
        energy -= 15
        if (energy < 20) println("$name устал!")
    }

    fun rest() {
        println("$name is resting...")
        energy += 20
    }

    fun levelUp() {
        level++
        maxEnergy += 20
        energy = maxEnergy
        println("$name is leveling up: $level |Max energy is raised up to: $maxEnergy")
    }
}
    fun main(){
        val worker = OutpostWorker("Anton")
        println("Energy: ${worker.energy}")
        println("Mood: ${worker.mood}")
        worker.work()
        worker.work()
        worker.work()
        println("Energy: ${worker.energy}")
        println("Mood: ${worker.mood}")
        worker.rest()
        worker.energy = 150
//        worker.level = 5
        worker.levelUp()
    }
