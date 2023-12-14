package importers

trait ImporterFromSource[S, T] extends Importer[T] {
  protected val source: S;
}
