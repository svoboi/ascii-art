package transformers.ASCIIFilters

import models.NumberASCIIArt

class InvertASCIIFilter extends ASCIIFilter {
  def invertLine(pixels: List[Double]): List[Double] = {
    pixels.map((pixel: Double) => 255 - pixel)
  }

  override def transform(art: NumberASCIIArt): NumberASCIIArt = {
    new NumberASCIIArt(art.pixels.map(invertLine))
  }
}
