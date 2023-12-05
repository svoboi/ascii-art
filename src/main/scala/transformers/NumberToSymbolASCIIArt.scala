package transformers

import models.{CharPixelsImage, NumberPixelsImage}

class NumberToSymbolASCIIArt(numberToCharTransformer: NumberToCharTransformer) extends Transformer[NumberPixelsImage, CharPixelsImage] {
  def transformTable(table: List[List[Double]]): List[List[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  override def transform(image: NumberPixelsImage): CharPixelsImage = {
    new CharPixelsImage(transformTable(image.getPixels()))
  }

}
