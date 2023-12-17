package transformers.pixelToCharTransformers

import transformers.NumberToCharTransformer

class LinearGrayscalePixelToCharTransformer(charactersTable: Array[Char]) extends NumberToCharTransformer {
  private val boxSize: Double = 255.0 / (charactersTable.length)

  override def transform(number: Double): Char = {
    if (number == 255.0) {
      charactersTable.charAt(charactersTable.length-1)
    }
    charactersTable.charAt((number / boxSize).floor.toInt)
  }
}
