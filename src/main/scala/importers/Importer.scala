package importers

trait Importer[T] {
  def importFunc(): T
}
