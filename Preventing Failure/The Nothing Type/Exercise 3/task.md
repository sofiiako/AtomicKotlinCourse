## The `Nothing` Type (#3)

Create `Failure` and `fail()` as in the previous two exercises, but do not call
`trace()` in `fail()`. Add a `private var _debug` at file scope, and initialize
it to `true`. Define `fun debug(test: Boolean)` so that it always calls
`trace()` to verify that it was called (see the starter code in `main()` to
discover the format of the `trace()` message), but only performs the `debug()`
activity if `_debug` is `true`. The starter code in `main()` tests your work.

<sub> This task doesn't contain the automatic tests,
it's always marked as "Correct" on "Check".
Please compare your solution with the provided one! </sub>