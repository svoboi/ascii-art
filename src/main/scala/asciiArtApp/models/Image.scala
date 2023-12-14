package asciiArtApp.models

trait Image[T] {
  protected val pixels: Seq[Seq[T]]

  def getPixels(): Seq[Seq[T]]

}
