package exporters

//source: Martin Drozdik, CTU class OOP, labs

trait Exporter[T] {
  /**
   * Exports something somewhere
   *
   * @param item The item to export
   */
  def exportFunc(item: T): Unit
}
