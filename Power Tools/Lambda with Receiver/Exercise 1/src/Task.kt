package lambdaWithReceiverExercise1

import atomictest.eq

fun drawSquare(width: Int) = buildString {
  repeat(width) {
    appendLine("*".repeat(width))
  }
}.trim()

fun main() {
  drawSquare(3) eq
    """|***
       |***
       |***""".trimMargin()
}