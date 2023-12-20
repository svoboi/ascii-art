package transformers.ASCIIFilters

import helpers.TestWithImages
import org.scalatest.FunSuite

class AdjustBrightnessFilterTest extends FunSuite
with TestWithImages {

  test("Adjust +20") {
    val brightnessFilter = new AdjustBrightnessFilter(+20)
    val greyscaleImage = generateGreyscaleImage(3, 3, 30)
    val updatedImage = brightnessFilter.transform(greyscaleImage)
    // 30 - 20
    assert(updatedImage.getPixels()(1)(1).toInt == 10)
  }

  test("Adjust +20 under 0") {
    val brightnessFilter = new AdjustBrightnessFilter(+20)
    val greyscaleImage = generateGreyscaleImage(3, 3, 10)
    val updatedImage = brightnessFilter.transform(greyscaleImage)
    // 10 - 20
    assert(updatedImage.getPixels()(1)(1).toInt == 0)
  }

  test("Adjust -20") {
    val brightnessFilter = new AdjustBrightnessFilter(-20)
    val greyscaleImage = generateGreyscaleImage(3, 3, 50)
    val updatedImage = brightnessFilter.transform(greyscaleImage)
    // 50 - (-20)
    assert(updatedImage.getPixels()(1)(1).toInt == 70)
  }

  test("Adjust -20 over 255") {
    val brightnessFilter = new AdjustBrightnessFilter(-20)
    val greyscaleImage = generateGreyscaleImage(3, 3, 250)
    val updatedImage = brightnessFilter.transform(greyscaleImage)
    // 10 - 20
    assert(updatedImage.getPixels()(1)(1).toInt == 255)
  }

}
