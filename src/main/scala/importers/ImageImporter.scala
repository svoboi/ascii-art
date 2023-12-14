package importers

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageImporter(protected val source: String) extends ImporterFromSource[String, BufferedImage]{
  override def importFunc(): BufferedImage = {
    ImageIO.read(new File(source));
  }
}
