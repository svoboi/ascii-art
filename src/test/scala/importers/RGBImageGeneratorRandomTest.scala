package importers

import importers.imageImporters.RGBImageGeneratorRandom
import org.scalatest.FunSuite

class RGBImageGeneratorRandomTest extends FunSuite {

  test("Generate success") {
    val importer = new RGBImageGeneratorRandom
    importer.importFunc()
  }

}
