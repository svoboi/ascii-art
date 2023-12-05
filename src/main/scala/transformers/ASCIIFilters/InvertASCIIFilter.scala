package transformers.ASCIIFilters

import models.NumberPixelsImage

class InvertASCIIFilter extends ASCIIFilter {
  def invertLine(pixels: Seq[Double]): Seq[Double] = {
    pixels.map((pixel: Double) => 255 - pixel)
  }

  override def transform(art: NumberPixelsImage): NumberPixelsImage = {
    new NumberPixelsImage(art.getPixels().map(invertLine))
  }
}
