package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state.txt"

    fun save(resources: List<ObservableResource>) {
        val content = resources.joinToString("\n") { "${it.name};${it.amount}" }
        File(FILE_NAME).writeText(content)
        println("State saved to $FILE_NAME")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("File $FILE_NAME not found")
            return emptyList()
        }
        return file.readLines().map { line ->
            val parts = line.split(";")
            ObservableResource(parts[0], parts[1].toInt())
        }
    }
}