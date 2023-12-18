package asciiArtApp.console.controllers

import exporters.ASCII.ASCIIExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{BuffImageToNumberImageTransformer, NumberToCharImageTransformer}

import java.awt.image.BufferedImage

class ConsoleController() extends Controller {

  def importFilterExport(
                          importer: Importer[BufferedImage],
                          bufferedImageToNumberImageTransformer: BuffImageToNumberImageTransformer,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: NumberToCharImageTransformer,
                          exporters: Seq[ASCIIExporter]
                        ): Unit = {
    val image = importer.importFunc();
    var numberImage = bufferedImageToNumberImageTransformer.transform(image);
    for (filter <- filters) {
      numberImage = filter.transform(numberImage);
    }
    val charImage = numberToCharImageTransformer.transform(numberImage);
    for (exporter <- exporters) {
      exporter.exportFunc(charImage);
    }
  }
}
