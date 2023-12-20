package asciiArtApp.console.views.parsers

import transformers.ASCIIFilters.{Axis, FlipASCIIFilter}

class FlipParser extends Parser[FlipASCIIFilter] {

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

