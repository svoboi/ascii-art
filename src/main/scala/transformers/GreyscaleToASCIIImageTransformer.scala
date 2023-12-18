package transformers

import asciiArtApp.models.{ASCIIImage, GreyScaleImage}

class GreyscaleToASCIIImageTransformer(numberToCharTransformer: NumberToCharTransformer) extends Transformer[GreyScaleImage, ASCIIImage] {
  def transformTable(table: Seq[Seq[Double]]): Seq[Seq[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  override def transform(image: GreyScaleImage): ASCIIImage = {
    new ASCIIImage(transformTable(image.getPixels()))
  }

}
