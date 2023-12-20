package transformers

import asciiArtApp.models.Image

/**
 * The ImageTransformer trait extends the Transformer trait for transforming images of type T.
 *
 * @tparam T The type of content within the image.
 */
trait ImageTransformer[T] extends Transformer[Image[T], Image[T]] {
}
