package asciiArtApp.models

/**
 * The ASCIIImage class represents an image with pixels of type Char, extending the Image trait.
 *
 * @param pixels The sequence of sequences representing the pixels of the ASCII image.
 */
class ASCIIImage(override protected val pixels: Seq[Seq[Char]]) extends Image[Char] {

  /**
   * Retrieves the pixels of the ASCII image.
   *
   * @return A sequence of sequences representing the pixels of the ASCII image.
   */
  override def getPixels(): Seq[Seq[Char]] = {
    pixels
  }
}
