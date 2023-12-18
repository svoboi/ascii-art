package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage

class InvertASCIIFilter extends ASCIIFilter {
  def invertLine(pixels: Seq[Double]): Seq[Double] = {
    pixels.map((pixel: Double) => 255 - pixel)
  }

  override def transform(art: GreyScaleImage): GreyScaleImage = {
    new GreyScaleImage(art.getPixels().map(invertLine))
  }
}
