package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.{Axis, FlipASCIIFilter}

/**
 * Parser for the '--flip' filter, responsible for parsing command line arguments
 * and constructing an FlipASCIIFilter instance.
 *
 * @tparam FlipASCIIFilter The type of argument to be parsed.
 */
class FlipParser extends Parser[FlipASCIIFilter] {

  /**
   * Parses command line arguments to create an FlipASCIIFilter instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An FlipASCIIFilter instance based on the parsed arguments.
   * @throws IllegalArgumentException If the number of arguments is incorrect or if
   *                                  the '--flip' direction is not defined.
   */
  override def parse(arguments: Seq[String]): FlipASCIIFilter = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 1 + " parameter.")
    }
    val axis = try {
      Axis.withName(arguments(1))
    }
    catch {
      case e: Exception => throw new IllegalArgumentException("This direction of flip is not defined!")
    }
    return new FlipASCIIFilter(axis)
  }

}

