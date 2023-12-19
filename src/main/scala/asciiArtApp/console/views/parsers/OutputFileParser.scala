package asciiArtApp.console.views.parsers

import exporters.text.FileOutputTextExporter

import java.io.File

class OutputFileParser extends Parser[FileOutputTextExporter] {

  def parse(arguments: Seq[String]): FileOutputTextExporter = {
    return new FileOutputTextExporter(new File(arguments(1)))
  }

}
