package asciiArtApp.console.views.parsers

import importers.imageImporters.{RGBImageImporterFromFile, RGBImageImporterFromJPG, RGBImageImporterFromPNG}

/**
 * Parser for the '--image' argument, responsible for parsing command line arguments
 * and constructing an RGBImageImporterFromFile instance.
 *
 * @tparam RGBImageImporterFromFile The type of argument to be parsed.
 */
class ImageImporterParser extends Parser[RGBImageImporterFromFile] {

  /**
   * Parses command line arguments to create an RGBImageGeneratorRandom instance.
   *
   * @param arguments The sequence of command line arguments.
   * @return An RGBImageImporterFromFile instance based on the parsed arguments.
   * @throws RGBImageImporterFromFile If the number of arguments is incorrect or file with unknown format is given.
   */
  override def parse(arguments: Seq[String]): RGBImageImporterFromFile = {
    if (arguments.length != 2) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 1 + " parameter.")
    }
    if (arguments(1).endsWith("jpg")) {
      return new RGBImageImporterFromJPG(arguments(1))
    }
    if (arguments(1).endsWith("png")) {
      return new RGBImageImporterFromPNG(arguments(1))
    }
    throw new IllegalArgumentException("Unknown format!")
  }
}
