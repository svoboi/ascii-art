package transformers

import asciiArtApp.models.ASCIIImage

class ASCIIImageToStringTransformer extends Transformer[ASCIIImage, String] {

  override def transform(image: ASCIIImage): String = {
    image.getPixels().map(_.mkString).mkString("\n")
  }
}
