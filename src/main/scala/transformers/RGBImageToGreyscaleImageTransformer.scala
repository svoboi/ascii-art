package transformers

import asciiArtApp.models.{GreyScaleImage, RGBImage}

/**
 * The RGBImageToGreyscaleImageTransformer class implements the Transformer trait to convert an RGBImage to a GreyscaleImage.
 */
class RGBImageToGreyscaleImageTransformer extends Transformer[RGBImage, GreyScaleImage] {

  /**
   * Transforms an RGBImage to a GreyscaleImage using a weighted average of color components.
   *
   * @param rgbImage The input RGBImage.
   * @return The transformed GreyscaleImage.
   */
  override def transform(rgbImage: RGBImage): GreyScaleImage = {
    var pixelsGS: List[List[Double]] = List.empty
    for (y <- rgbImage.getPixels().indices) {
      var pixelLineGS: List[Double] = List.empty
      val pixelLineRGB = rgbImage.getPixels()(y)
      for (x <- pixelLineRGB.indices) {
        // https://www.tutorialspoint.com/dip/grayscale_to_rgb_conversion.htm
        val pixel: Double = 255 - (pixelLineRGB(x).red * 0.3 + pixelLineRGB(x).blue * 0.59 + pixelLineRGB(x).green * 0.11)
        pixelLineGS = pixelLineGS.appended(pixel)
      }
      pixelsGS = pixelsGS.appended(pixelLineGS)
    }
    new GreyScaleImage(pixelsGS)
  }

}
