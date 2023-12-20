package transformers

import asciiArtApp.models.{ASCIIImage, GreyScaleImage}

/**
 * The GreyscaleToASCIIImageTransformer class implements the Transformer trait to convert a GreyscaleImage to an ASCIIImage.
 *
 * @param numberToCharTransformer The transformer for converting pixel values to characters.
 */
class GreyscaleToASCIIImageTransformer(numberToCharTransformer: NumberToCharTransformer) extends Transformer[GreyScaleImage, ASCIIImage] {

  /**
   * Transforms a sequence of pixel values into a sequence of ASCII characters.
   *
   * @param table The sequence of sequences representing the pixel values.
   * @return The sequence of sequences representing the ASCII characters.
   */
  def transformTable(table: Seq[Seq[Double]]): Seq[Seq[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  /**
   * Transforms a GreyscaleImage to an ASCIIImage.
   *
   * @param image The input GreyscaleImage.
   * @return The transformed ASCIIImage.
   */
  override def transform(image: GreyScaleImage): ASCIIImage = {
    new ASCIIImage(transformTable(image.getPixels()))
  }

}
