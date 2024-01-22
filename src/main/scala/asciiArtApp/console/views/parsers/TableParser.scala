package asciiArtApp.console.views.parsers

import transformers.NumberToCharTransformer
import transformers.OneGreyscalePixelToCharTransformers.{HigherContrastGreyscalePixelToCharTransformer, LinearGreyscalePixelToCharTransformer}

/**
 * Parser for the '--table' argument, responsible for parsing command line arguments
 * and constructing an NumberToCharTransformer instance.
 * bourke-small and bourke-standard tables are creation of Paul Borke: http://www.paulbourke.net/dataformats/asciiart/
 *
 * @tparam NumberToCharTransformer The type of argument to be parsed.
 */
class TableParser extends Parser[NumberToCharTransformer] {

  /**
   * Parses command line arguments to create an StdOutputTextExporter instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An NumberToCharTransformer instance based on the parsed arguments.
   * @throws NumberToCharTransformer If the number of arguments is incorrect or the name of the table is not recognized.
   */
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
