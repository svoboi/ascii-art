package transformers

import asciiArtApp.models.{RGBImage, RGBPixel}
import org.scalatest.FunSuite

class RGBImageToGreyscaleImageTest extends FunSuite {
  val transformer = new RGBImageToGreyscaleImage

  def generateRGBImage(height: Int, width: Int, pixel: RGBPixel): RGBImage = {
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until 3) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until 3) {
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    new RGBImage(pixels)
  }

  test("Success with 0") {
    val pixel: RGBPixel = new RGBPixel(0, 0, 0)
    val rgbImage = generateRGBImage(3, 3, pixel)
    val greyscaleImage = transformer.transform(rgbImage)
    assert(greyscaleImage.getPixels()(1)(1) == 255)
  }

  test("Success with 1") {
    val pixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbImage = generateRGBImage(3, 3, pixel)
    val greyscaleImage = transformer.transform(rgbImage)
    assert(greyscaleImage.getPixels()(1)(1) == 255 - (1 * 0.3 + 1 * 0.59 + 1 * 0.11))
  }

  test("Success with 255") {
    val pixel: RGBPixel = new RGBPixel(255, 255, 255)
    val rgbImage = generateRGBImage(3, 3, pixel)
    val greyscaleImage = transformer.transform(rgbImage)
    assert(greyscaleImage.getPixels()(1)(1) == 0)
  }
}
