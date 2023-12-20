package asciiArtApp.models

class ASCIIImage(override protected val pixels: Seq[Seq[Char]]) extends Image[Char] {
  override def getPixels(): Seq[Seq[Char]] = {
    pixels
  }
}
