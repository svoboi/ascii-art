package transformers.ASCIIFilters

import models.{Image, NumberASCIIArt}

class FlipASCIIFilter(direction: Char) extends ASCIIFilter {
  override def transform(art: Image[Double]): Image[Double] = {
    direction match {
      case 'x' => new NumberASCIIArt(art.pixels.map((pixelLine: List[Double]) => pixelLine.reverse))
      case 'y' => new NumberASCIIArt(art.pixels.reverse)
      case 'd' => new NumberASCIIArt(art.pixels.reverse.map((pixelLine: List[Double]) => pixelLine.reverse))
      case _ => throw new Exception("This direction is not defined!")
    }
  }
}
