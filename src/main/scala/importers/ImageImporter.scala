package importers

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageImporter extends Importer[BufferedImage]{
  override def importFunc(source: String): BufferedImage = {
    ImageIO.read(new File(source));
  }
}
