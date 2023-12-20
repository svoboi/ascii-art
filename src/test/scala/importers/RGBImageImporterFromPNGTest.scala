package importers

import helpers.TestWithImages
import importers.imageImporters.RGBImageImporterFromPNG
import org.scalatest.FunSuite

class RGBImageImporterFromPNGTest extends FunSuite
  with TestWithImages {

  test("Import png success") {
    val fileName = getTestFileImage
    createImage(fileName, "png")
    val importer = new RGBImageImporterFromPNG(fileName + ".png")
    val rbgImage = importer.importFunc()
    val green = rbgImage.getPixels()(0)(0).green
    val red = rbgImage.getPixels()(0)(0).red
    val blue = rbgImage.getPixels()(0)(0).blue
    assert(rbgImage.getPixels()(0)(0).green == 0)
    assert(rbgImage.getPixels()(0)(0).red == 0)
    assert(rbgImage.getPixels()(0)(0).blue == 0)
    ensureDeleted(fileName + ".png")
  }

  test("Import jpg failure") {
    val fileName = getTestFileImage
    createImage(fileName, "jpg")
    val importer = new RGBImageImporterFromPNG(fileName + ".jpg")
    assertThrows[Exception] {
      importer.importFunc()
    }
    ensureDeleted(fileName + ".jpg")
  }
}
