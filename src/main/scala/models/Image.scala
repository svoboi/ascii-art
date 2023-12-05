package models

trait Image[T] {
  protected val pixels: List[List[T]]
}
