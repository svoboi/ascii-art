package asciiArtApp.console.views.parsers

import transformers.NumberToCharTransformer
import transformers.OneGreyscalePixelToCharTransformers.{HigherContrastGreyscalePixelToCharTransformer, LinearGreyscalePixelToCharTransformer}

class TableParser extends Parser[NumberToCharTransformer] {

  override def parse(arguments: Seq[String]): NumberToCharTransformer = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 1 + " parameter.")
    }
    if (arguments(1) == "bourke-small") {
      return new LinearGreyscalePixelToCharTransformer(" .:-=+*#%@".toCharArray)
    }
    if (arguments(1) == "bourke-standard") {
      return new LinearGreyscalePixelToCharTransformer(
        " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray
      )
    }
    if (arguments(1) == "non-linear") {
      return new HigherContrastGreyscalePixelToCharTransformer
    }
    throw new IllegalArgumentException("Unknown table!")
  }

}
