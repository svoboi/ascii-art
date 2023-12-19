package asciiArtApp.console.views.parsers

import importers.imageImporters.{RGBImageImporterFromFile, RGBImageImporterFromJPG, RGBImageImporterFromPNG}

class ImageImporterParser extends Parser[RGBImageImporterFromFile] {
  def parse(arguments: Seq[String]): RGBImageImporterFromFile = {
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
