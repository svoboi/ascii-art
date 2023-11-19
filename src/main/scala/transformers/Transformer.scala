package transformers

trait Transformer[T, S] {
  def transform(source: T): S
}
