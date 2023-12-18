package asciiArtApp.console.controllers

import asciiArtApp.models.RGBImage
import exporters.ASCII.ASCIIExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImage}

trait Controller {
  def importFilterExport(
                          importer: Importer[RGBImage],
                          rgbImageToNumberImageTransformer: RGBImageToGreyscaleImage,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          exporters: Seq[ASCIIExporter]
                        ): Unit
}
