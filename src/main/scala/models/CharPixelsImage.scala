package models

class CharPixelsImage(protected val pixels: List[List[Char]]) extends Image[Char] {
  def getPixels(): List[List[Char]] = {
    pixels
  }
}
