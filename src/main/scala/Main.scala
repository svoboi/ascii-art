package Main

import exporters.ASCII.StdOutputASCIIExporter
import transformers.ASCIIFilters.{AdjustBrightnessFilter, FlipASCIIFilter, InvertASCIIFilter}
import transformers.{LinearNumberToSymbolTransformer, BufferedImageToNumberImageTransformer, NumberToCharImageTransformer}

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object Main extends App {
  val imagePath = "exampleSMALLER.png"
  val myPicture : BufferedImage = ImageIO.read(new File(imagePath))

  val tablelist: Array[Char] = " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray
  val linearTransformer: LinearNumberToSymbolTransformer = new LinearNumberToSymbolTransformer(tablelist)
  val numberASCIITransformer: BufferedImageToNumberImageTransformer = new BufferedImageToNumberImageTransformer
  val symbolASCIITransformer: NumberToCharImageTransformer = new NumberToCharImageTransformer(linearTransformer)
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

  streamExporter.export(finalArt)

}
