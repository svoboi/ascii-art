package exporters

/**
 * The Exporter trait for exporting T content.
 *
 * @tparam T The type of content to be exported.
 * @author Martin Drozdik, course OOP on CTU, https://courses.fit.cvut.cz/BI-OOP
 */
trait Exporter[T] {
  /**
   * Exports something somewhere
   *
   * @param item The item to export
   */
  def exportFunc(item: T): Unit
}
