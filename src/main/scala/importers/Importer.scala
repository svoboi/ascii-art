package importers

/**
 * The Importer trait defines the contract for importing content of type T.
 *
 * @tparam T The type of content to be imported.
 */
trait Importer[T] {

  /**
   * Imports content of type T.
   *
   * @return The imported content of type T.
   */
  def importFunc(): T
}
