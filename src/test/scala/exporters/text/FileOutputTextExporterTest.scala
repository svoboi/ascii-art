package exporters.text

import helpers.TestWithFiles
import org.scalatest.FunSuite

import java.io.File

//source: Martin Drozdik, CTU class OOP, labs

class FileOutputTextExporterTest extends FunSuite
  with TestWithFiles {

  test("No file exists") {
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputTextExporter(file)

      exporter.exportFunc("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
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
      val exporter = new FileOutputTextExporter(file)

      exporter.exportFunc("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally {
      ensureDeleted(fileName)
    }
  }
}
