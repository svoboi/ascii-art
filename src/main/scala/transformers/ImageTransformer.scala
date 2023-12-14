package transformers

import asciiArtApp.models.Image

trait ImageTransformer[T] extends Transformer[Image[T], Image[T]] {
}
