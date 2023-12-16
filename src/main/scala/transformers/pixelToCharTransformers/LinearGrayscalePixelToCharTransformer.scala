package transformers.PixelToCharTransformer

import transformers.NumberToCharTransformer

class LinearGrayscalePixelToCharTransformer(charactersTable: Array[Char]) extends NumberToCharTransformer {
  private val boxSize: Double = 255.0 / (charactersTable.length - 1)

  override def transform(number: Double): Char = {
    charactersTable.charAt((number / boxSize).floor.toInt)
  }
}
