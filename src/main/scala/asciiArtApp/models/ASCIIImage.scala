package asciiArtApp.models

class ASCIIImage(protected val pixels: Seq[Seq[Char]]) extends Image[Char] {
  def getPixels(): Seq[Seq[Char]] = {
    pixels
  }
}
