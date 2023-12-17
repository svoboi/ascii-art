package transformers.pixelToCharTransformers

import transformers.NumberToCharTransformer

class HigherMiddleContrastGrayscalePixelToCharTransformer extends NumberToCharTransformer{
  private val charactersTable: Array[Char] = " .:-=+*#%@".toCharArray
  // - 2 for the two characters used on 0-50 and 200-255
  private val boxSize : Double = (200.0 - 50.0) / (charactersTable.length - 2)

  override def transform(number: Double): Char = {
    if (number == 255.0) {
      charactersTable.charAt(charactersTable.length - 1)
    }
    if (number < 50) return charactersTable(0)
    if (number < 200) return charactersTable(((number-50) / boxSize).floor.toInt + 1)
    return charactersTable(9)
  }
}
