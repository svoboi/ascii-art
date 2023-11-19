package exporters.ASCII

import models.SymbolASCIIArt

import java.io.OutputStream

class StreamASCIIExporter (outputStream: OutputStream) extends ASCIIExporter {
  private var closed = false

  protected def exportToStream(art: SymbolASCIIArt): Unit = {
    if (closed)
      throw new Exception("The stream is already closed")

    for (el <- art.pixels) {
      for (letter <- el) {
        outputStream.write(letter)
      }
      outputStream.write('\n')
    }
    outputStream.flush()
  }



  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  override def export(art: SymbolASCIIArt): Unit = {
    exportToStream(art)
  }
}
