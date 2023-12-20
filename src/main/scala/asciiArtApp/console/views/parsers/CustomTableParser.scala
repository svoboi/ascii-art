package asciiArtApp.console.views.parsers

import transformers.NumberToCharTransformer
import transformers.OneGreyscalePixelToCharTransformers.LinearGreyscalePixelToCharTransformer

class CustomTableParser extends Parser[NumberToCharTransformer] {

  override def parse(arguments: Seq[String]): NumberToCharTransformer = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 1 + " parameter.")
    }
    if (arguments(1).isEmpty) {
      throw new IllegalArgumentException("Custom table can't be empty.")
    }
    return new LinearGreyscalePixelToCharTransformer(arguments(1).toCharArray)
  }

}
