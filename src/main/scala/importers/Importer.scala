package importers

trait Importer[S, T] {
  def importFunc(source: S): T
}
