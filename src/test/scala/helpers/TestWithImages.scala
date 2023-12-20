package helpers

import asciiArtApp.models.GreyScaleImage

import java.awt.image.BufferedImage
import java.io.File
import java.util.UUID
import javax.imageio.ImageIO

trait TestWithImages extends TestWithFiles {

  def getTestFileImage: String = testFolder + UUID.randomUUID().toString


  def createImage(filePath: String, extension: String): Unit = {
    val imageWidth = 10
    val imageHeight = 10
    val bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0)
    val file = new File(filePath + "." + extension)
    ensureCreated(filePath + "." + extension)
    ImageIO.write(bufferedImage, extension, file)
  }

  def generateGreyscaleImage(height: Int, width: Int, filler: Double): GreyScaleImage = {
    var pixels: List[List[Double]] = List.empty
    for (y <- 0 until height) {
      var pixelLine: List[Double] = List.empty
      for (x <- 0 until width) {
        pixelLine = pixelLine.appended(filler)
      }
      pixels = pixels.appended(pixelLine)
    }
    new GreyScaleImage(pixels)
  }

  def greyscaleImageWithGivenPixelUpdated(target: GreyScaleImage, height: Int, width: Int, filler: Double): GreyScaleImage = {
    val pixels = target.getPixels().toArray.map((a) => a.toArray);
    pixels(height)(width) = filler
    new GreyScaleImage(pixels.toSeq.map((a) => a.toSeq))
  }

}
