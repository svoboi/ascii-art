package transformers

/**
 * The Transformer trait defines the contract for transforming content from type T to type S.
 *
 * @tparam T The type of content to be transformed.
 * @tparam S The type of transformed content.
 */
trait Transformer[T, S] {

  /**
   * Transforms content from type T to type S.
   *
   * @param source The source content of type T.
   * @return The transformed content of type S.
   */
  def transform(source: T): S
}
