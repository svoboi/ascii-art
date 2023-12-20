package transformers.ASCIIFilters

import helpers.TestWithImages
import org.scalatest.FunSuite

class InvertASCIIFilterTest extends FunSuite
  with TestWithImages {

  test("Invert starting at 255") {
    val invertFilter = new InvertASCIIFilter
    val greyscaleImage = generateGreyscaleImage(3, 3, 255)
    val updatedImage = invertFilter.transform(greyscaleImage)
    assert(updatedImage.getPixels()(0)(0).toInt == 0)
  }

  test("Invert starting at 0") {
    val invertFilter = new InvertASCIIFilter
    val greyscaleImage = generateGreyscaleImage(3, 3, 0)
    val updatedImage = invertFilter.transform(greyscaleImage)
    assert(updatedImage.getPixels()(0)(0).toInt == 255)
  }

  test("Invert starting at 128") {
    val invertFilter = new InvertASCIIFilter
    val greyscaleImage = generateGreyscaleImage(3, 3, 127.5)
    val updatedImage = invertFilter.transform(greyscaleImage)
    assert(updatedImage.getPixels()(0)(0) == 127.5)
  }

}
