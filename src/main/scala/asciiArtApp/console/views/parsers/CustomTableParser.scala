package asciiArtApp.console.views.parsers

import transformers.NumberToCharTransformer
import transformers.OneGreyscalePixelToCharTransformers.LinearGreyscalePixelToCharTransformer

/**
 * Parser for the '--custom-table' argument, responsible for parsing command line arguments
 * and constructing an NumberToCharTransformer instance.
 *
 * @tparam NumberToCharTransformer The type of argument to be parsed.
 */
class CustomTableParser extends Parser[NumberToCharTransformer] {

  /**
   * Parses command line arguments to create an NumberToCharTransformer instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An NumberToCharTransformer instance based on the parsed arguments.
   * @throws NumberToCharTransformer If the number of arguments is incorrect or if
   *                                 the '--custom-table' parameter is followed by an empty table.
   */
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
