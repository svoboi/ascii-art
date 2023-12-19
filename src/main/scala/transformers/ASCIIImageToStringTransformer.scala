package transformers

import asciiArtApp.models.ASCIIImage

class ASCIIImageToStringTransformer extends Transformer[ASCIIImage, String] {

  override def transform(image: ASCIIImage): String = {
    var string : String = new String()
    for(line <- image.getPixels()) {
      string = string.concat(line.mkString)
      string = string.concat("\n")
    }
    string
  }
}
