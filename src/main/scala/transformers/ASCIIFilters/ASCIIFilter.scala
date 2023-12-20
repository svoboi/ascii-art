package transformers.ASCIIFilters

import asciiArtApp.models.GreyScaleImage
import transformers.Transformer

/**
 * The ASCIIFilter trait extends the Transformer trait for transforming a greyscale image into another greyscale image.
 */
trait ASCIIFilter extends Transformer[GreyScaleImage, GreyScaleImage] {

}
