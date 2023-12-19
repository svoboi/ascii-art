package asciiArtApp.console.views.parsers

import exporters.text.StdOutputTextExporter

class OutputConsoleParser extends Parser[StdOutputTextExporter] {

  def parse(arguments: Seq[String]): StdOutputTextExporter = {
    if (arguments.length != 1) {
      throw new IllegalArgumentException("Argument '" + arguments.head + "' takes " + 0 + " parameters.")
    }
    new StdOutputTextExporter
  }

}
