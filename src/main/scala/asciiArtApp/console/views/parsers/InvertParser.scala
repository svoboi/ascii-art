package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.InvertASCIIFilter

class InvertParser {

  def parse(arguments: Seq[String]): InvertASCIIFilter = {
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    return new InvertASCIIFilter()
  }

}
