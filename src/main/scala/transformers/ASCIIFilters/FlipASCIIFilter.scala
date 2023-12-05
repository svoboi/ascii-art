package transformers.ASCIIFilters

import models.NumberPixelsImage

class FlipASCIIFilter(direction: Char) extends ASCIIFilter {
  override def transform(art: NumberPixelsImage): NumberPixelsImage = {
    direction match {
      case 'x' => new NumberPixelsImage(art.getPixels().map((pixelLine: List[Double]) => pixelLine.reverse))
      case 'y' => new NumberPixelsImage(art.getPixels().reverse)
      case 'd' => new NumberPixelsImage(art.getPixels().reverse.map((pixelLine: List[Double]) => pixelLine.reverse))
      case _ => throw new Exception("This direction is not defined!")
    }
  }
}
