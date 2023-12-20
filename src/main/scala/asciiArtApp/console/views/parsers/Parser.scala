package asciiArtApp.console.views.parsers

/**
 * A trait defining the contract for parsers, responsible for parsing
 * command line arguments and producing an instance of type T.
 *
 * @tparam T The type of object to be parsed and returned.
 */
trait Parser[T] {
  /**
   * Parses command line arguments to create an instance of type T.
   *
   * @param arguments The sequence of command line arguments.
   * @return An instance of type T based on the parsed arguments.
   */
  def parse(arguments: Seq[String]): T

}
