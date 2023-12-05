package models

trait Image[T] {
  def pixels: List[List[T]]
}
