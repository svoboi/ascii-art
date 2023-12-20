package transformers.OneGreyscalePixelToCharTransformers

import transformers.NumberToCharTransformer

/**
 * The LinearGreyscalePixelToCharTransformer class implements the NumberToCharTransformer trait
 * to transform greyscale pixel values to characters using a linear mapping.
 *
 * @param charactersTable The array of characters representing the mapping.
 */
class LinearGreyscalePixelToCharTransformer(charactersTable: Array[Char]) extends NumberToCharTransformer {
  private val boxSize: Double = 255.0 / (charactersTable.length)

  /**
   * Transforms a greyscale pixel value to a character using a linear mapping.
   *
   * @param number The greyscale pixel value.
   * @return The corresponding character based on the linear mapping.
   * @throws IllegalArgumentException If the pixel value is outside the valid range [0, 255].
   */
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
