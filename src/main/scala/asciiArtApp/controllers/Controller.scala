package asciiArtApp.controllers

import asciiArtApp.models.RGBImage
import exporters.text.TextExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{ASCIIImageToStringTransformer, GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImage}

trait Controller {
  def importFilterExport(
                          importer: Importer[RGBImage],
                          rgbImageToNumberImageTransformer: RGBImageToGreyscaleImage,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          asciiImageToStringTransformer: ASCIIImageToStringTransformer,
                          exporters: Seq[TextExporter]
                        ): Unit
}
