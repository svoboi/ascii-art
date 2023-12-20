package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage
import transformers.ASCIIFilters.Axis.{Axis, D, X, Y}

/**
 * The FlipASCIIFilter class implements the ASCIIFilter trait to flip a greyscale image along a specified axis.
 *
 * @param direction The axis along which the greyscale image should be flipped (X, Y, or D).
 */
class FlipASCIIFilter(direction: Axis) extends ASCIIFilter {

  /**
   * Transforms a greyscale image by flipping it along the specified axis.
   *
   * @param art The input greyscale image.
   * @return The transformed greyscale image after flipping.
   * @throws IllegalArgumentException If the specified direction is not defined.
   */
  override def transform(art: GreyScaleImage): GreyScaleImage = {
    direction match {
      case X => new GreyScaleImage(art.getPixels().map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case Y => new GreyScaleImage(art.getPixels().reverse)
      case D => new GreyScaleImage(art.getPixels().reverse.map((pixelLine: Seq[Double]) => pixelLine.reverse))
      case _ => throw new IllegalArgumentException("This direction is not defined!")
    }
  }
}
