package exporters.text

import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

//source: Martin Drozdik, CTU class OOP, labs

class StreamTextExporterTest extends FunSuite {
  test("Write") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.exportFunc("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }
}
