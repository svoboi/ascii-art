package transformers

import asciiArtApp.models.NumberPixelsImage
import java.awt.Color
import java.awt.image.BufferedImage

class BufferedImageToNumberImageTransformer extends Transformer[BufferedImage, NumberPixelsImage] {

  def transformLine(image: BufferedImage, x: Int, y: Int): List[Double] = {
    if (x == image.getWidth) {
      return List.empty
    }
    val pixelColor: Color = new Color(image.getRGB(x, y))
    val gValue: Double = 255 - (pixelColor.getRed.toDouble * 0.3 + pixelColor.getBlue.toDouble * 0.59 + pixelColor.getGreen.toDouble * 0.11)
    gValue +: transformLine(image, x + 1, y)
  }

  def transformTable(image: BufferedImage, x: Int, y: Int): List[List[Double]] = {
    if (y == image.getHeight) {
      return List.empty
    }
    transformLine(image, 0, y) +: transformTable(image, 0, y + 1)
  }

  override def transform(image: BufferedImage): NumberPixelsImage = {
    new NumberPixelsImage(transformTable(image, 0, 0))
  }
}
