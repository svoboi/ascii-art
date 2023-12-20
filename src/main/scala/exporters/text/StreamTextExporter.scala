package exporters.text

import java.io.OutputStream

/**
 * The StreamTextExporter class implements the TextExporter trait to export text-based content to an OutputStream.
 *
 * @param outputStream The OutputStream where the text content will be exported.
 * @author Martin Drozdik, course OOP on CTU, https://courses.fit.cvut.cz/BI-OOP
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  /**
   * Exports the provided text to the specified OutputStream.
   *
   * @param text The text content to be exported.
   * @throws IOException If an I/O error occurs during the export process.
   */
  protected def exportToStream(text: String): Unit = {

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Closes the OutputStream associated with this exporter.
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Overrides the exportFunc method from the TextExporter trait to delegate the export to the OutputStream.
   *
   * @param item The text content to be exported.
   */
  override def exportFunc(item: String): Unit = exportToStream(item)
}
