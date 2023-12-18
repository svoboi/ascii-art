package importers

import org.scalatest.FunSuite

class RGBImageImporterFromJPGTest extends FunSuite {


  test("Import jpg success") {
    val importer = new RGBImageImporterFromJPG("examples/side-eye-smaller.jpg")
    importer.importFunc()
  }

  test("Import png failure") {
    val importer = new RGBImageImporterFromJPG("examples/planet-smaller.png")
    assertThrows[Exception] {
      importer.importFunc()
    }
  }
}
