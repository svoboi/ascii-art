package transformers.OneGreyscalePixelToCharTransformers

import org.scalatest.FunSuite

class HigherContrastGreyscalePixelToCharTransformerTest extends FunSuite {
  val transformer = new HigherContrastGreyscalePixelToCharTransformer

  test("Success with 0") {
    assert(transformer.transform(0) == ' ')
  }

  test("Success with 150") {
    assert(transformer.transform(150) == '*')
  }

  test("Success with 245") {
    assert(transformer.transform(245) == '@')
  }

  test("Success with 255") {
    assert(transformer.transform(255) == '@')
  }

  test("Failure with -1") {
    assertThrows[Exception] {
      transformer.transform(-1)
    }
  }

  test("Failure with 300") {
    assertThrows[Exception] {
      transformer.transform(300)
    }
  }

}
