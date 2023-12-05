package models

class CharPixelsImage(protected val pixels: Seq[Seq[Char]]) extends Image[Char] {
  def getPixels(): Seq[Seq[Char]] = {
    pixels
  }
}
