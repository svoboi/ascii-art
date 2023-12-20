package asciiArtApp.models

/**
 * The Image trait defines a generic contract for representing images with pixels of type T.
 *
 * @tparam T The type of pixels in the image.
 */
trait Image[T] {
  protected val pixels: Seq[Seq[T]]

  /**
   * Retrieves the pixels of the image.
   *
   * @return A sequence of sequences representing the pixels of the image.
   */
  def getPixels(): Seq[Seq[T]]

}
