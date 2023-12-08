package transformers

import models.{CharPixelsImage, NumberPixelsImage}

class NumberToCharImageTransformer(numberToCharTransformer: NumberToCharTransformer) extends Transformer[NumberPixelsImage, CharPixelsImage] {
  def transformTable(table: Seq[Seq[Double]]): Seq[Seq[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  override def transform(image: NumberPixelsImage): CharPixelsImage = {
    new CharPixelsImage(transformTable(image.getPixels()))
  }

}
