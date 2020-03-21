## Companion Objects (#2)

Begin with these two interfaces:

```kotlin
interface BoardGame {
  fun move(): Boolean
  companion object {
    fun createBoard() {
      trace("BoardGame.createBoard()")
    }
  }
}

interface GameFactory {
  fun create(): BoardGame
}
```

Create two classes, `Checkers` and `Chess` which inherit `BoardGame`. Give them
both `private` constructors with no arguments. Each class should contain a
`companion object Factory : GameFactory` which calls `createBoard()` in its
constructor. Each `companion object` contains a `const val max` which is used
within `move()`. The definitions of `playGame()` and `main()` are provided;
complete the code in `Checkers` and `Chess` so it satisfies the tests in
`main()`.

```kotlin
// CompanionObjects/CompanionEx2.kt
package companionobjectex2
import atomictest.*

private val trace = Trace()

interface BoardGame {
  fun move(): Boolean
  companion object {
    fun createBoard() {
      trace("BoardGame.createBoard()")
    }
  }
}

interface GameFactory {
  fun create(): BoardGame
}

class
Checkers private constructor() : BoardGame {
  private var moves = 0
  override fun move(): Boolean {
    trace("Checkers move $moves")
    return ++moves != max
  }
  companion object Factory : GameFactory {
    private const val max = 3
    init {
      BoardGame.createBoard()
    }
    override fun create() = Checkers()
  }
}

class
Chess private constructor() : BoardGame {
  private var moves = 0
  override fun move(): Boolean {
    trace("Chess move $moves")
    return ++moves != max
  }
  companion object Factory : GameFactory {
    private const val max = 4
    init {
      BoardGame.createBoard()
    }
    override fun create() = Chess()
  }
}

fun playGame(factory: GameFactory) {
  val s = factory.create()
  while (s.move())
    ;
}

fun main() {
  playGame(Checkers.Factory)
  playGame(Chess.Factory)
  trace eq """
  BoardGame.createBoard()
  Checkers move 0
  Checkers move 1
  Checkers move 2
  BoardGame.createBoard()
  Chess move 0
  Chess move 1
  Chess move 2
  Chess move 3
  """
}
```