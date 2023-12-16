package Main

import exporters.ASCII.StdOutputASCIIExporter
import transformers.ASCIIFilters.{AdjustBrightnessFilter, FlipASCIIFilter, InvertASCIIFilter}
import transformers.pixelToCharTransformers.{HigherMiddleContrastGrayscalePixelToCharTransformer, LinearGrayscalePixelToCharTransformer}
import transformers.{BufferedImageToNumberImageTransformer, NumberToCharImageTransformer}

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object Main extends App {
  val imagePath = "side-eye.jpg"
  val myPicture : BufferedImage = ImageIO.read(new File(imagePath))

  val tablelist: Array[Char] = " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray
  val linearTransformer: LinearGrayscalePixelToCharTransformer = new LinearGrayscalePixelToCharTransformer(tablelist)
  val nonlinearTransformer = new HigherMiddleContrastGrayscalePixelToCharTransformer
  val numberASCIITransformer: BufferedImageToNumberImageTransformer = new BufferedImageToNumberImageTransformer

//  val symbolASCIITransformer: NumberToCharImageTransformer = new NumberToCharImageTransformer(linearTransformer)
  val symbolASCIITransformer: NumberToCharImageTransformer = new NumberToCharImageTransformer(nonlinearTransformer)


  val invertASCIITransformer: InvertASCIIFilter = new InvertASCIIFilter
  val brightnessFilter: AdjustBrightnessFilter = new AdjustBrightnessFilter(5)

  val transformedArt = numberASCIITransformer.transform(myPicture)
  val xFlipper: FlipASCIIFilter = new FlipASCIIFilter('x')
  val yFlipper: FlipASCIIFilter = new FlipASCIIFilter('y')
  val flippedArt = yFlipper.transform(transformedArt)
  val invertedArt = invertASCIITransformer.transform(flippedArt)
  val brighterArt = brightnessFilter.transform(invertedArt)

  val finalArt = symbolASCIITransformer.transform(brighterArt)

  val streamExporter = new StdOutputASCIIExporter

  streamExporter.exportFunc(finalArt)

}
