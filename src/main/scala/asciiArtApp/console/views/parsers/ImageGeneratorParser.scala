package asciiArtApp.console.views.parsers

import importers.imageImporters.RGBImageGeneratorRandom

/**
 * Parser for the '--image-random' argument, responsible for parsing command line arguments
 * and constructing an RGBImageGeneratorRandom instance.
 *
 * @tparam RGBImageGeneratorRandom The type of argument to be parsed.
 */
class ImageGeneratorParser extends Parser[RGBImageGeneratorRandom] {

  /**
   * Parses command line arguments to create an RGBImageGeneratorRandom instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An RGBImageGeneratorRandom instance based on the parsed arguments.
   * @throws RGBImageGeneratorRandom If the number of arguments is incorrect.
   */
  override def parse(arguments: Seq[String]): RGBImageGeneratorRandom = {
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    return new RGBImageGeneratorRandom
  }

}
