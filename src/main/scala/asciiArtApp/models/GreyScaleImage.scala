package asciiArtApp.models

class GreyScaleImage(override protected val pixels: Seq[Seq[Double]]) extends Image[Double] {
  override def getPixels(): Seq[Seq[Double]] = {
    pixels
  }
}
