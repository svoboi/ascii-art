package transformers.ASCIIFilters

import models.{Image, NumberASCIIArt}

class InvertASCIIFilter extends ASCIIFilter {
  def invertLine(pixels: List[Double]): List[Double] = {
    pixels.map((pixel: Double) => 255 - pixel)
  }

  override def transform(art: Image[Double]): Image[Double] = {
    new NumberASCIIArt(art.pixels.map(invertLine))
  }
}
