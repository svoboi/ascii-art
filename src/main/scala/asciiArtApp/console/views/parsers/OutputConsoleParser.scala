package asciiArtApp.console.views.parsers

import exporters.text.StdOutputTextExporter

/**
 * Parser for the '--output-console' argument, responsible for parsing command line arguments
 * and constructing an StdOutputTextExporter instance.
 *
 * @tparam StdOutputTextExporter The type of argument to be parsed.
 */
class OutputConsoleParser extends Parser[StdOutputTextExporter] {

  /**
   * Parses command line arguments to create an StdOutputTextExporter instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An StdOutputTextExporter instance based on the parsed arguments.
   * @throws StdOutputTextExporter If the number of arguments is incorrect.
   */
  override def parse(arguments: Seq[String]): StdOutputTextExporter = {
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    new StdOutputTextExporter
  }

}
