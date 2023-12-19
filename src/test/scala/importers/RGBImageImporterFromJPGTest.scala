package importers

import helpers.TestWithImages
import importers.imageImporters.RGBImageImporterFromJPG
import org.scalatest.FunSuite

class RGBImageImporterFromJPGTest extends FunSuite
  with TestWithImages {


  test("Import jpg success") {
    val fileName = getTestFileImage
    createImage(fileName, "jpg")
    val importer = new RGBImageImporterFromJPG(fileName + "." + "jpg")
    val rbgImage = importer.importFunc()
    val green = rbgImage.getPixels()(0)(0).green
    val red = rbgImage.getPixels()(0)(0).red
    val blue = rbgImage.getPixels()(0)(0).blue
    assert(rbgImage.getPixels()(0)(0).green == 0)
    assert(rbgImage.getPixels()(0)(0).red == 0)
    assert(rbgImage.getPixels()(0)(0).blue == 0)
  }

  test("Import png failure") {
    val fileName = getTestFileImage
    createImage(fileName, "png")
    val importer = new RGBImageImporterFromJPG(fileName + "." + "png")
    assertThrows[Exception] {
      importer.importFunc()
    }
  }
}
