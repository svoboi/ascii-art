package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.AdjustBrightnessFilter

/**
 * Parser for the '--brightness' filter, responsible for parsing command line arguments
 * and constructing an AdjustBrightnessFilter instance.
 *
 * @tparam AdjustBrightnessFilter The type of argument to be parsed.
 */
class BrightnessParser extends Parser[AdjustBrightnessFilter] {

  /**
   * Parses command line arguments to create an AdjustBrightnessFilter instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An AdjustBrightnessFilter instance based on the parsed arguments.
   * @throws IllegalArgumentException If the number of arguments is incorrect or if
   *                                  the '--brightness' parameter is not followed by a valid number.
   */
  override def parse(arguments: Seq[String]): AdjustBrightnessFilter = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 1 + " parameter.")
    }
    val intOpt = arguments(1).toIntOption
    if (intOpt.isEmpty) {
      throw new IllegalArgumentException("Filter '--brightness' requires a number parameter.")
    }
    return new AdjustBrightnessFilter(intOpt.get)
  }

}
