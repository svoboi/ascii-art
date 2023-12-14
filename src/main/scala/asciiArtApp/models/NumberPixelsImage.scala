package asciiArtApp.models

class NumberPixelsImage(protected val pixels: Seq[Seq[Double]]) extends Image[Double] {
  def getPixels(): Seq[Seq[Double]] = {
    pixels
  }
}
