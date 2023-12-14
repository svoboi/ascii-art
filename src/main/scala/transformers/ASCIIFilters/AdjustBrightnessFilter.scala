package transformers.ASCIIFilters

import asciiArtApp.models.NumberPixelsImage

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

  def adjustTable(pixels: Seq[Double]): Seq[Double] = {
    pixels.map(brightnessChange)
  }

  override def transform(art: NumberPixelsImage): NumberPixelsImage = {
    new NumberPixelsImage(art.getPixels().map(adjustTable))
  }
}
