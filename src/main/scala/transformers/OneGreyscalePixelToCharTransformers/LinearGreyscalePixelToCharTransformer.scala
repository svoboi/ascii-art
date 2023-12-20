package transformers.OneGreyscalePixelToCharTransformers

import transformers.NumberToCharTransformer

class LinearGreyscalePixelToCharTransformer(charactersTable: Array[Char]) extends NumberToCharTransformer {
  private val boxSize: Double = 255.0 / (charactersTable.length)

  override def transform(number: Double): Char = {
    if (number < 0 || number > 255) {
      throw new IllegalArgumentException("Pixel needs to be between 0 and 255.")
    }
    if ((number / boxSize).floor.toInt >= charactersTable.length) {
      return charactersTable.charAt(charactersTable.length - 1)
    }
    charactersTable.charAt((number / boxSize).floor.toInt)
  }
}
