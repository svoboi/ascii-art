package exporters.ASCII

import asciiArtApp.models.{CharPixelsImage, Image}
import helpers.TestWithFiles
import org.scalatest.FunSuite

import java.io.File

class FileOutputASCIIExporterTest extends FunSuite
  with TestWithFiles{
  test("No file exists") {
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputASCIIExporter(file)
      val art :Image[Char] = new CharPixelsImage(Seq(Seq('a', 'b', 'c'), Seq('d', 'e')))

      exporter.exportFunc(art)
      exporter.close()

      assertFileContent(fileName, "abc\nde\n")
    }
    finally {
      ensureDeleted(fileName)
    }
  }

  test("File already exists") {
    val fileName = getTestFile

    try {
      ensureCreated(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputASCIIExporter(file)
      val art :Image[Char] = new CharPixelsImage(Seq(Seq('a'), Seq('b'), Seq('c')))

      exporter.exportFunc(art)
      exporter.close()

      assertFileContent(fileName, "a\nb\nc\n")
    }
    finally {
      ensureDeleted(fileName)
    }
  }
}
