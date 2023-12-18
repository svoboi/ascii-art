package importers

import asciiArtApp.models.{RGBImage, RGBPixel}

class RGBImageGeneratorRandom extends Importer[RGBImage]{
  def importFunc(): RGBImage = {
    val rand = new scala.util.Random
    val width = rand.nextInt(100)
    val height = rand.nextInt(100)
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until width) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until height) {
        val pixel = new RGBPixel(
          rand.nextDouble()*255,
          rand.nextDouble()*255,
          rand.nextDouble()*255
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    new RGBImage(pixels)
  }
}
