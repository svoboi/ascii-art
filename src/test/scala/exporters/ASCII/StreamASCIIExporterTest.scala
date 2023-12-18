package exporters.text

import asciiArtApp.models.{ASCIIImage, Image}
import exporters.ASCII.StreamASCIIExporter
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

class StreamASCIIExporterTest extends FunSuite {
  test("Write") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamASCIIExporter(stream)
    val art :Image[Char] = new ASCIIImage(Seq(Seq('a', 'b', 'c'), Seq('d', 'e')))

    exporter.exportFunc(art)

    assert(stream.toString("UTF-8") == "abc\nde\n")
  }
}