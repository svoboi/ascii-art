package asciiArtApp.models

class RGBImage(override protected val pixels: Seq[Seq[RGBPixel]]) extends Image[RGBPixel] {
  override def getPixels(): Seq[Seq[RGBPixel]] = {
    pixels
  }
}
