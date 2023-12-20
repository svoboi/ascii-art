package asciiArtApp.controllers

import asciiArtApp.models.RGBImage
import exporters.text.TextExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{ASCIIImageToStringTransformer, GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImageTransformer}

/**
 * The Controller trait defines the contract for handling the flow of importing an RGB image,
 * applying a sequence of filters, transforming it into ASCII art, and exporting the result using
 * multiple exporters.
 */
trait Controller {

  /**
   * Imports an RGB image, applies a sequence of filters, transforms it into ASCII art, and
   * exports the result using multiple exporters.
   *
   * @param importer                         The importer for retrieving the RGB image.
   * @param rgbImageToNumberImageTransformer The transformer for converting RGB image to a number-based image.
   * @param filters                          The sequence of ASCII filters to be applied.
   * @param numberToCharImageTransformer     The transformer for converting number-based image to character-based image.
   * @param asciiImageToStringTransformer    The transformer for converting ASCII image to a string representation.
   * @param exporters                        The sequence of text exporters for outputting the final ASCII art.
   */
  def importFilterExport(
                          importer: Importer[RGBImage],
                          rgbImageToNumberImageTransformer: RGBImageToGreyscaleImageTransformer,
                          filters: Seq[ASCIIFilter],
                          numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                          asciiImageToStringTransformer: ASCIIImageToStringTransformer,
                          exporters: Seq[TextExporter]
                        ): Unit
}
