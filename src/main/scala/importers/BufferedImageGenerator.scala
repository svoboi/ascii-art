package importers

import java.awt.image.BufferedImage

class BufferedImageGenerator extends Importer[BufferedImage]{
  def importFunc(): BufferedImage = {
    new BufferedImage (100, 100, BufferedImage.TYPE_INT_RGB)
    //todo the rest of generating, and random size
  }
}
