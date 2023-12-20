package transformers.ASCIIFilters

import helpers.TestWithImages
import org.scalatest.FunSuite

class FlipASCIIFilterTest extends FunSuite
  with TestWithImages {

  test("Flip over X axis") {
    val flipFilter = new FlipASCIIFilter(Axis.X)
    val greyscaleImage = generateGreyscaleImage(3, 3, 255)
    val imageWithWhitePixel = greyscaleImageWithGivenPixelUpdated(greyscaleImage, 0, 0, 0)
    val updatedImage = flipFilter.transform(imageWithWhitePixel)
    assert(updatedImage.getPixels()(0)(2).toInt == 0)
  }

  test("Flip over Y axis") {
    val flipFilter = new FlipASCIIFilter(Axis.Y)
    val greyscaleImage = generateGreyscaleImage(3, 3, 255)
    val imageWithWhitePixel = greyscaleImageWithGivenPixelUpdated(greyscaleImage, 0, 0, 0)
    val updatedImage = flipFilter.transform(imageWithWhitePixel)
    assert(updatedImage.getPixels()(2)(0).toInt == 0)
  }

  test("Flip over D axis") {
    val flipFilter = new FlipASCIIFilter(Axis.D)
    val greyscaleImage = generateGreyscaleImage(3, 3, 255)
    val imageWithWhitePixel = greyscaleImageWithGivenPixelUpdated(greyscaleImage, 0, 0, 0)
    val updatedImage = flipFilter.transform(imageWithWhitePixel)
    assert(updatedImage.getPixels()(2)(2).toInt == 0)
  }
}
