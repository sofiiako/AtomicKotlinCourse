// Interfaces/Task1.kt
package interfacesExercise1
import atomictest.eq

interface Computer {
  fun calculateAnswer(): Int
}

class Cloud(n: Int): Computer {
  val list: List<Node> = List(n) { Node(it) }
  override fun calculateAnswer(): Int {
    return list.sumBy { it.calculateAnswer() }
  }
}

data class Node(val result: Int): Computer {
  override fun calculateAnswer() = result
}

fun main() {
  Cloud(10).calculateAnswer() eq 45
}