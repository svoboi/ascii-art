package transformers

import models.{NumberASCIIArt, SymbolASCIIArt}

class NumberToSymbolASCIIArt(numberToCharTransformer: NumberToCharTransformer) extends Transformer[NumberASCIIArt, SymbolASCIIArt] {
  def transformTable(table: List[List[Double]]): List[List[Char]] = {
    if (table == List.empty) {
      return List.empty
    }
    table.head.map((pixel: Double) => numberToCharTransformer.transform(pixel)) +: transformTable(table.tail)
  }

  override def transform(image: NumberASCIIArt): SymbolASCIIArt = {
    new SymbolASCIIArt(transformTable(image.pixels))
  }

}
