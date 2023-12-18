package asciiArtApp.models

class GreyScaleImage(protected val pixels: Seq[Seq[Double]]) extends Image[Double] {
  def getPixels(): Seq[Seq[Double]] = {
    pixels
  }
}
