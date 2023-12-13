package controller

trait ArgumentWithParameter[T] extends Argument {
  val parameterValue : T
}
