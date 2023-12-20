package transformers.OneGreyscalePixelToCharTransformers

import transformers.NumberToCharTransformer

/**
 * The HigherContrastGreyscalePixelToCharTransformer class implements the NumberToCharTransformer trait
 * to transform greyscale pixel values to characters using a higher-contrast mapping.
 */
class HigherContrastGreyscalePixelToCharTransformer extends NumberToCharTransformer {
  private val charactersTable: Array[Char] = " .:-=+*#%@".toCharArray
  // - 2 for the two characters used on 0-50 and 200-255
  private val boxSize: Double = (200.0 - 50.0) / (charactersTable.length - 2)

  /**
   * Transforms a greyscale pixel value to a character using a higher-contrast mapping.
   *
   * @param number The greyscale pixel value.
   * @return The corresponding character based on the higher-contrast mapping.
   * @throws IllegalArgumentException If the pixel value is outside the valid range [0, 255].
   */
  override def transform(number: Double): Char = {
    if (number < 0 || number > 255) {
      throw new IllegalArgumentException("Pixel needs to be between 0 and 255.")
    }
    if (number < 50) return charactersTable(0)
    if (((number - 50) / boxSize).floor.toInt + 1 >= charactersTable.length) {
      return charactersTable.charAt(charactersTable.length - 1)
    }
    if (number < 200) return charactersTable(((number - 50) / boxSize).floor.toInt + 1)
    return charactersTable(9)
  }
}
