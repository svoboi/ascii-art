package asciiArtApp.models

/**
 * The GreyscaleImage class represents an image with pixels of type Double, extending the Image trait.
 *
 * @param pixels The sequence of sequences representing the pixels of the greyscale image.
 */
class GreyScaleImage(override protected val pixels: Seq[Seq[Double]]) extends Image[Double] {

  /**
   * Retrieves the pixels of the greyscale image.
   *
   * @return A sequence of sequences representing the pixels of the greyscale image.
   */
  override def getPixels(): Seq[Seq[Double]] = {
    pixels
  }
}
