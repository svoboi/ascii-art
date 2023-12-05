package transformers.ASCIIFilters

import models.NumberASCIIArt

class AdjustBrightnessFilter(amount: Int) extends ASCIIFilter {
  def brightnessChange(pixel: Double): Double = {
    if (pixel - amount > 255.0) {
      return 255
    }
    if (pixel - amount < 0.0) {
      return 0
    }
    pixel - amount
  }

  def adjustTable(pixels: List[Double]): List[Double] = {
    pixels.map(brightnessChange)
  }

  override def transform(art: NumberASCIIArt): NumberASCIIArt = {
    new NumberASCIIArt(art.getPixels().map(adjustTable))
  }
}
