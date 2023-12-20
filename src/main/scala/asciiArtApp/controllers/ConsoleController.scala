package asciiArtApp.controllers

import asciiArtApp.models.RGBImage
import exporters.text.TextExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{ASCIIImageToStringTransformer, GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImage}

class ConsoleController() extends Controller {

  override def importFilterExport(
                          importer: Importer[RGBImage],
                          rgbImageToNumberImageTransformer: RGBImageToGreyscaleImage,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          asciiImageToStringTransformer: ASCIIImageToStringTransformer,
                          exporters: Seq[TextExporter]
                        ): Unit = {
    val image = importer.importFunc();
    var numberImage = rgbImageToNumberImageTransformer.transform(image);
    for (filter <- filters) {
      numberImage = filter.transform(numberImage);
    }
    val charImage = numberToCharImageTransformer.transform(numberImage);
    val stringImage = asciiImageToStringTransformer.transform(charImage)
    for (exporter <- exporters) {
      exporter.exportFunc(stringImage);
    }
  }
}
