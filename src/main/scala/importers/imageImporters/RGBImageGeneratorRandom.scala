package importers.imageImporters

import asciiArtApp.models.{RGBImage, RGBPixel}
import importers.Importer

class RGBImageGeneratorRandom extends Importer[RGBImage] {
  override def importFunc(): RGBImage = {
    val rand = new scala.util.Random
    val width = rand.nextInt(100)
    val height = rand.nextInt(100)
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until width) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until height) {
        val pixel = new RGBPixel(
          rand.nextInt(255),
          rand.nextInt(255),
          rand.nextInt(255)
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    new RGBImage(pixels)
  }
}
