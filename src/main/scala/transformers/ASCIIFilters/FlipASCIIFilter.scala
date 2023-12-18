package transformers.ASCIIFilters

import asciiArtApp.models.NumberPixelsImage
import transformers.ASCIIFilters.Axis.{D, FlipAxis, X, Y}

class FlipASCIIFilter(direction: FlipAxis) extends ASCIIFilter {
  override def transform(art: NumberPixelsImage): NumberPixelsImage = {
    direction match {
      case X => new NumberPixelsImage(art.getPixels().map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case Y => new NumberPixelsImage(art.getPixels().reverse)
      case D => new NumberPixelsImage(art.getPixels().reverse.map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case _ => throw new Exception("This direction is not defined!")
    }
  }
}
