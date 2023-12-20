package importers.imageImporters

import asciiArtApp.models.{RGBImage, RGBPixel}
import importers.ImporterFromSource

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * The RGBImageImporterFromFile trait extends the ImporterFromSource trait for importing RGBImage from a file.
 *
 * @tparam String   The type of source, representing the file path.
 * @tparam RGBImage The type of content to be imported.
 */
trait RGBImageImporterFromFile extends ImporterFromSource[String, RGBImage] {
  protected val source: String
  protected val allowedExtension: String

  /**
   * Transforms a BufferedImage into an RGBImage.
   *
   * @param buffImage The BufferedImage to be transformed.
   * @return An RGBImage representing the content of the BufferedImage pixels.
   */
  protected def transformBuffImageToRGBImage(buffImage: BufferedImage): RGBImage = {
    var pixels: List[List[RGBPixel]] = List.empty
    for (y <- 0 until buffImage.getHeight) {
      var pixelLine: List[RGBPixel] = List.empty
      for (x <- 0 until buffImage.getWidth) {
        val pixelColor: Color = new Color(buffImage.getRGB(x, y))
        val pixel: RGBPixel = new RGBPixel(
          pixelColor.getRed,
          pixelColor.getGreen,
          pixelColor.getBlue
        )
        pixelLine = pixelLine.appended(pixel)
      }
      pixels = pixels.appended(pixelLine)
    }
    new RGBImage(pixels)
  }

  /**
   * Retrieves the file extension from the source file path.
   *
   * @return The file extension of the source file.
   */
  protected def getExtension(): String = {
    var extension = ""
    val i = source.lastIndexOf('.')
    if (i > 0) {
      extension = source.substring(i + 1);
    }
    extension
  }

  /**
   * Imports an RGBImage from the specified source file.
   *
   * @return The imported RGBImage.
   * @throws IllegalArgumentException If the file extension is not allowed.
   */
  override def importFunc(): RGBImage = {
    if (getExtension() != allowedExtension) {
      throw new IllegalArgumentException("Unknown format.")
    }
    val file = new File(source)
    val buffImage = ImageIO.read(file)
    if (buffImage == null) {
      throw new IllegalArgumentException("Unable to read file.")
    }
    transformBuffImageToRGBImage(buffImage)
  }

}
