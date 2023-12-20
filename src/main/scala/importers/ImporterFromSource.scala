package importers

/**
 * The ImporterFromSource trait extends the Importer trait and adds the capability of specifying a source for importing content.
 *
 * @tparam S The type of source from which content is imported.
 * @tparam T The type of content to be imported.
 */
trait ImporterFromSource[S, T] extends Importer[T] {
  protected val source: S;
}
