package importers

import java.awt.image.BufferedImage

class BufferedImageGenerator extends Importer[BufferedImage]{
  def importFunc(): BufferedImage = {
    val rand = new scala.util.Random
    val width = rand.nextInt(100)
    val height = rand.nextInt(100)
    val image : BufferedImage = new BufferedImage (width.toInt, height.toInt, BufferedImage.TYPE_INT_RGB)
    for (x <- 0 until width.toInt) {
      for (y <- 0 until height.toInt) {
//        val pixelValue = ((random()*10000000000L)%16777215).toInt
        val pixelValue = rand.nextInt(16777215)
        image.setRGB(x, y, pixelValue);
      }
    }
    return image;
  }
}
