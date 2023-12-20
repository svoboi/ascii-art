package transformers

import helpers.TestWithImages
import org.scalatest.FunSuite
import transformers.OneGreyscalePixelToCharTransformers.LinearGreyscalePixelToCharTransformer

class GreyscaleToASCIIImageTransformerTest extends FunSuite
  with TestWithImages {
  val transformer = new GreyscaleToASCIIImageTransformer(new LinearGreyscalePixelToCharTransformer(" .:-=+*#%@".toCharArray))

  test("Success with 0") {
    val greyscaleImage = generateGreyscaleImage(3, 3, 0)
    val ASCII = transformer.transform(greyscaleImage)
    assert(ASCII.getPixels()(1)(1) == ' ')
  }

  test("Success with 150") {
    val greyscaleImage = generateGreyscaleImage(3, 3, 150)
    val ASCII = transformer.transform(greyscaleImage)
    assert(ASCII.getPixels()(1)(1) == '+')
  }

  test("Success with 255") {
    val greyscaleImage = generateGreyscaleImage(3, 3, 255)
    val ASCII = transformer.transform(greyscaleImage)
    assert(ASCII.getPixels()(1)(1) == '@')
  }
}
