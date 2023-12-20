package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage

/**
 * The AdjustBrightnessFilter class implements the ASCIIFilter trait to adjust the brightness of a greyscale image.
 *
 * @param amount The amount by which to adjust the brightness (positive or negative).
 */
class AdjustBrightnessFilter(amount: Int) extends ASCIIFilter {

  /**
   * Adjusts the brightness of a single pixel value.
   *
   * @param pixel The original pixel value.
   * @return The adjusted pixel value.
   * @throws IllegalArgumentException If the pixel value is outside the valid range [0, 255].
   */
  def brightnessChange(pixel: Double): Double = {
    if (pixel > 255 || pixel < 0) {
      throw new IllegalArgumentException("Pixel needs to be between 0 and 255.")
    }
    if (pixel - amount > 255.0) {
      return 255
    }
    if (pixel - amount < 0.0) {
      return 0
    }
    pixel - amount
  }

  /**
   * Adjusts the brightness of a sequence of pixel values.
   *
   * @param pixels The sequence of original pixel values.
   * @return The sequence of adjusted pixel values.
   */
  def adjustTable(pixels: Seq[Double]): Seq[Double] = {
    pixels.map(brightnessChange)
  }

  /**
   * Transforms a greyscale image by adjusting its brightness.
   *
   * @param art The input greyscale image.
   * @return The transformed greyscale image with adjusted brightness.
   */
  override def transform(art: GreyScaleImage): GreyScaleImage = {
    new GreyScaleImage(art.getPixels().map(adjustTable))
  }
}
