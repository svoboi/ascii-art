package asciiArtApp.models

class RGBImage (protected val pixels: Seq[Seq[RGBPixel]]) extends Image[RGBPixel]{
  def getPixels(): Seq[Seq[RGBPixel]] = {
    pixels
  }
}
