package asciiArtApp.models

/**
 * The RGBImage class represents an image with pixels of type RGBPixel, extending the Image trait.
 *
 * @param pixels The sequence of sequences representing the pixels of the RGB image.
 */
class RGBImage(override protected val pixels: Seq[Seq[RGBPixel]]) extends Image[RGBPixel] {

  /**
   * Retrieves the pixels of the RGB image.
   *
   * @return A sequence of sequences representing the pixels of the RGB image.
   */
  override def getPixels(): Seq[Seq[RGBPixel]] = {
    pixels
  }
}
