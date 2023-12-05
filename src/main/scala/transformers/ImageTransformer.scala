package transformers

import models.Image

trait ImageTransformer[T] extends Transformer[Image[T], Image[T]] {
}
