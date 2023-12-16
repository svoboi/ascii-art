package exporters

trait Exporter[T] {
  /**
   * Exports something somewhere
   *
   * @param item The item to export
   */
  def exportFunc(item: T): Unit
}