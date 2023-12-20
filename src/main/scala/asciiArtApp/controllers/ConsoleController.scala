package asciiArtApp.controllers

import asciiArtApp.models.RGBImage
import exporters.text.TextExporter
import importers.Importer
import transformers.ASCIIFilters.ASCIIFilter
import transformers.{ASCIIImageToStringTransformer, GreyscaleToASCIIImageTransformer, RGBImageToGreyscaleImageTransformer}

/**
 * The ConsoleController class extends the Controller trait and implements the
 * importFilterExport method to handle the flow of importing, applying filters, and exporting
 * ASCII art representations of images through various exporters.
 */
class ConsoleController() extends Controller {

  /**
   * Imports an RGB image, applies a sequence of filters, transforms it into ASCII art, and
   * exports the result using multiple exporters.
   *
   * @param importer                            The importer for retrieving the RGB image.
   * @param rgbImageToGreyscaleImageTransformer The transformer for converting RGB image to a greyscale image.
   * @param filters                             The sequence of ASCII filters to be applied.
   * @param numberToCharImageTransformer        The transformer for converting number-based image to character-based image.
   * @param asciiImageToStringTransformer       The transformer for converting ASCII image to a string representation.
   * @param exporters                           The sequence of text exporters for outputting the final ASCII art.
   */
  override def importFilterExport(
                                   importer: Importer[RGBImage],
                                   rgbImageToGreyscaleImageTransformer: RGBImageToGreyscaleImageTransformer,
                                   filters: Seq[ASCIIFilter],
                                   numberToCharImageTransformer: GreyscaleToASCIIImageTransformer,
                                   asciiImageToStringTransformer: ASCIIImageToStringTransformer,
                                   exporters: Seq[TextExporter]
                                 ): Unit = {
    val image = importer.importFunc();
    var numberImage = rgbImageToGreyscaleImageTransformer.transform(image);
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
