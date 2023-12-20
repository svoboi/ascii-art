package transformers

import asciiArtApp.models.ASCIIImage

/**
 * The ASCIIImageToStringTransformer class implements the Transformer trait to convert an ASCIIImage to a String.
 */
class ASCIIImageToStringTransformer extends Transformer[ASCIIImage, String] {

  /**
   * Transforms an ASCIIImage to a String representation.
   *
   * @param image The input ASCIIImage.
   * @return The transformed String representation.
   */
  override def transform(image: ASCIIImage): String = {
    image.getPixels().map(_.mkString).mkString("\n")
  }
}
