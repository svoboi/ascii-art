package asciiArtApp.console.views.parsers

import exporters.text.FileOutputTextExporter

import java.io.File

/**
 * Parser for the '--output-file' argument, responsible for parsing command line arguments
 * and constructing an FileOutputTextExporter instance.
 *
 * @tparam FileOutputTextExporter The type of argument to be parsed.
 */
class OutputFileParser extends Parser[FileOutputTextExporter] {

  /**
   * Parses command line arguments to create an StdOutputTextExporter instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An FileOutputTextExporter instance based on the parsed arguments.
   * @throws FileOutputTextExporter If the number of arguments is incorrect.
   */
  override def parse(arguments: Seq[String]): FileOutputTextExporter = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 2 + " parameters.")
    }
    return new FileOutputTextExporter(new File(arguments(1)))
  }

}
