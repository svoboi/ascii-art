package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage

class InvertASCIIFilter extends ASCIIFilter {
  def invertLine(pixels: Seq[Double]): Seq[Double] = {
    pixels.map((pixel: Double) => {
      if (pixel < 0 || pixel > 255) {
        throw new IllegalArgumentException("Pixel needs to be between 0 and 255.")
      }
      255 - pixel
    })
  }

  override def transform(art: GreyScaleImage): GreyScaleImage = {
    new GreyScaleImage(art.getPixels().map(invertLine))
  }
}
