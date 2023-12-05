package importers

trait Importer[T] {
  def importFunc(source: String): T
}
