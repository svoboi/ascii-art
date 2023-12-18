package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage
import transformers.ASCIIFilters.Axis.{D, FlipAxis, X, Y}

class FlipASCIIFilter(direction: FlipAxis) extends ASCIIFilter {
  override def transform(art: GreyScaleImage): GreyScaleImage = {
    direction match {
      case X => new GreyScaleImage(art.getPixels().map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case Y => new GreyScaleImage(art.getPixels().reverse)
      case D => new GreyScaleImage(art.getPixels().reverse.map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case _ => throw new Exception("This direction is not defined!")
    }
  }
}
