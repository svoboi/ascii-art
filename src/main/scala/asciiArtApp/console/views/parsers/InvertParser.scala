package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.InvertASCIIFilter

/**
 * Parser for the '--invert' filter, responsible for parsing command line arguments
 * and constructing an InvertASCIIFilter instance.
 *
 * @tparam InvertASCIIFilter The type of argument to be parsed.
 */
class InvertParser extends Parser[InvertASCIIFilter] {

  override def parse(arguments: Seq[String]): InvertASCIIFilter = {
    /**
     * Parses command line arguments to create an InvertASCIIFilter instance.
     *
     * @param arguments The sequence of command line arguments.
     * @return An AdjustBrightnessFilter instance based on the parsed arguments.
     * @throws InvertASCIIFilter If the number of arguments is incorrect.
     */
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    return new InvertASCIIFilter()
  }

}
