package transformers

import asciiArtApp.models.{RGBImage, RGBPixel}
import org.scalatest.FunSuite

class RGBImageToGreyscaleImageTest extends FunSuite {
  val transformer = new RGBImageToGreyscaleImage
  test("Success with 1") {
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until 3) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until 3) {
        val pixel: RGBPixel = new RGBPixel(1, 1, 1
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    val rgbImage = new RGBImage(pixels)
    val greyscaleImage = transformer.transform(rgbImage)
    assert(greyscaleImage.getPixels()(1)(1) == 255 - (1 * 0.3 + 1 * 0.59 + 1 * 0.11))
  }

  test("Success with 255") {
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until 3) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until 3) {
        val pixel: RGBPixel = new RGBPixel(255, 255, 255
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    val rgbImage = new RGBImage(pixels)
    val greyscaleImage = transformer.transform(rgbImage)
    assert(greyscaleImage.getPixels()(1)(1) == 255 - (255 * 0.3 + 255 * 0.59 + 255 * 0.11))
  }
}
