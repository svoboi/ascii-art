package transformers

import asciiArtApp.models.{GreyScaleImage, RGBImage}

class RGBImageToGreyscaleImage extends Transformer[RGBImage, GreyScaleImage] {

  def transform(rgbImage: RGBImage): GreyScaleImage = {
    var pixelsGS: List[List[Double]] = List.empty
    for (y <- rgbImage.getPixels().indices) {
      var pixelLineGS: List[Double] = List.empty
      val pixelLineRGB = rgbImage.getPixels()(y)
      for (x <- pixelLineRGB.indices) {
        val pixel: Double = 255 - (pixelLineRGB(x).red * 0.3 + pixelLineRGB(x).blue * 0.59 + pixelLineRGB(x).green * 0.11)
        pixelLineGS = pixelLineGS.appended(pixel)
      }
      pixelsGS = pixelsGS.appended(pixelLineGS)
    }
    new GreyScaleImage(pixelsGS)
  }

}
