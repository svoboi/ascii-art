package exporters.text

import java.io.OutputStream

//source: Martin Drozdik, CTU class OOP, labs

class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  protected def exportToStream(text: String): Unit = {

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  override def exportFunc(item: String): Unit = exportToStream(item)
}
