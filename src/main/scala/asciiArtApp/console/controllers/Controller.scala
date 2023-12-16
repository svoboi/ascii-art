package asciiArtApp.console.controllers

import exporters.ASCII.ASCIIExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{BufferedImageToNumberImageTransformer, NumberToCharImageTransformer}

import java.awt.image.BufferedImage

trait Controller {
  def importFilterExport(
                          importer: Importer[BufferedImage],
                          bufferedImageToNumberImageTransformer: BufferedImageToNumberImageTransformer,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: NumberToCharImageTransformer,
                          exporters: Seq[ASCIIExporter]
                        ): Unit
}
