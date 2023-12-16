package transformers.pixelToCharTransformers

import transformers.NumberToCharTransformer

class HigherMiddleContrastGrayscalePixelToCharTransformer extends NumberToCharTransformer{
  private val charactersTable: Array[Char] = " .:-=+*#%@".toCharArray
  // - 3 because theres - 2 for the two characters used on sides
  private val boxSize : Double = (200.0 - 50.0) / (charactersTable.length - 3)

  override def transform(number: Double): Char = {
    if (number < 50) return charactersTable(0)
    if (number < 200) return charactersTable((number / boxSize).floor.toInt)
    return charactersTable(9)
  }
}
