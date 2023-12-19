package helpers

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

}
