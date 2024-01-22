package exporters.text

import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

/**
 * @author Martin Drozdik, course OOP on CTU, https://courses.fit.cvut.cz/BI-OOP
 */

class StreamTextExporterTest extends FunSuite {
  test("Write") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.exportFunc("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }
}
