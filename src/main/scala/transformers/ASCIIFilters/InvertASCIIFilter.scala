package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage

/**
 * The InvertASCIIFilter class implements the ASCIIFilter trait to invert the colors of a greyscale image.
 */
class InvertASCIIFilter extends ASCIIFilter {

  /**
   * Inverts a sequence of pixel values.
   *
   * @param pixels The sequence of original pixel values.
   * @return The sequence of inverted pixel values.
   * @throws IllegalArgumentException If any pixel value is outside the valid range [0, 255].
   */
  def invertLine(pixels: Seq[Double]): Seq[Double] = {
    pixels.map((pixel: Double) => {
      if (pixel < 0 || pixel > 255) {
        throw new IllegalArgumentException("Pixel needs to be between 0 and 255.")
      }
      255 - pixel
    })
  }

  /**
   * Transforms a greyscale image by inverting its colors.
   *
   * @param art The input greyscale image.
   * @return The transformed greyscale image after color inversion.
   */
  override def transform(art: GreyScaleImage): GreyScaleImage = {
    new GreyScaleImage(art.getPixels().map(invertLine))
  }
}
