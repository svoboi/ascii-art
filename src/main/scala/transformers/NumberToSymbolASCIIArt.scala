package transformers

import models.{Image, SymbolASCIIArt}

class NumberToSymbolASCIIArt(numberToCharTransformer: NumberToCharTransformer) extends Transformer[Image[Double], Image[Char]] {
  def transformTable(table: List[List[Double]]): List[List[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  override def transform(image: Image[Double]): Image[Char] = {
    new SymbolASCIIArt(transformTable(image.pixels))
  }

}
