package asciiArtApp.console.controllers

import asciiArtApp.models.RGBImage
import exporters.ASCII.ASCIIExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImage}

class ConsoleController() extends Controller {

  def importFilterExport(
                          importer: Importer[RGBImage],
                          rgbImageToNumberImageTransformer: RGBImageToGreyscaleImage,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          exporters: Seq[ASCIIExporter]
                        ): Unit = {
    val image = importer.importFunc();
    var numberImage = rgbImageToNumberImageTransformer.transform(image);
    for (filter <- filters) {
      numberImage = filter.transform(numberImage);
    }
    val charImage = numberToCharImageTransformer.transform(numberImage);
    for (exporter <- exporters) {
      exporter.exportFunc(charImage);
    }
  }
}
