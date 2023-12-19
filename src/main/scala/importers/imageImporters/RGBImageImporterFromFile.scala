package importers.imageImporters

import asciiArtApp.models.{RGBImage, RGBPixel}
import importers.ImporterFromSource

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

trait RGBImageImporterFromFile extends ImporterFromSource[String, RGBImage] {
  protected val source: String
  protected val allowedExtension: String

  protected def transformBuffImageToRGBImage(buffImage: BufferedImage): RGBImage = {
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until buffImage.getHeight) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until buffImage.getWidth) {
        val pixelColor: Color = new Color(buffImage.getRGB(x, y))
        val pixel: RGBPixel = new RGBPixel(
          pixelColor.getRed.toDouble,
          pixelColor.getGreen.toDouble,
          pixelColor.getBlue.toDouble
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    new RGBImage(pixels)
  }

  protected def getExtension(): String = {
    var extension = ""
    val i = source.lastIndexOf('.')
    if (i > 0) {
      extension = source.substring(i + 1);
    }
    extension
  }

  override def importFunc(): RGBImage = {
    if (getExtension() != allowedExtension) {
      throw new IllegalArgumentException("Unknown format.")
    }
    val file = new File(source)
    val buffImage = ImageIO.read(file)
    transformBuffImageToRGBImage(buffImage)
  }

}
