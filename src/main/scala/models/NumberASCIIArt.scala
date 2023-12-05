package models

class NumberASCIIArt (protected val pixels: List[List[Double]]) extends Image[Double] {
  def getPixels(): List[List[Double]] = {
    pixels
  }
}
