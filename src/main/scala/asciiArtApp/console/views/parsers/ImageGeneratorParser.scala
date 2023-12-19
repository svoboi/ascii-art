package asciiArtApp.console.views.parsers

import importers.imageImporters.RGBImageGeneratorRandom

class ImageGeneratorParser {

  def parse(arguments: Seq[String]): RGBImageGeneratorRandom = {
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    return new RGBImageGeneratorRandom
  }

}
