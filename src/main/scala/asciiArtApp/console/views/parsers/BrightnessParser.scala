package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.AdjustBrightnessFilter

class BrightnessParser extends Parser[AdjustBrightnessFilter] {

  def parse(arguments: Seq[String]): AdjustBrightnessFilter = {
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
