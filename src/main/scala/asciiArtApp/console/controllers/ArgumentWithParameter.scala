package asciiArtApp.console.controllers

trait ArgumentWithParameter[T] extends Argument {
  val parameterValue : T
}
