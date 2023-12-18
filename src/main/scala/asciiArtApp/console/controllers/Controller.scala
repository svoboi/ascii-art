package asciiArtApp.console.controllers

import exporters.ASCII.ASCIIExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{BuffImageToNumberImageTransformer, GreyscaleToASCIIImageTransformer}

import java.awt.image.BufferedImage

trait Controller {
  def importFilterExport(
                          importer: Importer[BufferedImage],
                          bufferedImageToNumberImageTransformer: BuffImageToNumberImageTransformer,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          exporters: Seq[ASCIIExporter]
                        ): Unit
}
