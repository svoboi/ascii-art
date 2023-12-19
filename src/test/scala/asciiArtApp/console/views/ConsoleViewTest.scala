package asciiArtApp.console.views

import asciiArtApp.console.controllers.ConsoleController
import asciiArtApp.models.RGBImage
import exporters.ASCII.ASCIIExporter
import exporters.text.StdOutputTextExporter
import importers.Importer
import org.scalatest.FunSuite
import transformers.ASCIIFilters.ASCIIFilter
import transformers.NumberToCharTransformer

class ConsoleViewTest extends FunSuite {
  val consoleView: ConsoleView = new ConsoleView(new ConsoleController, new StdOutputTextExporter)

  test("Grouping arguments") {
    val arguments = List("--image", "exampleSMALLER.png", "--invert")
    val groupedArguments = consoleView.groupArguments(arguments)
    assert(groupedArguments.head.name == "image")
    assert(groupedArguments.head.parameters.head == "exampleSMALLER.png")
    assert(groupedArguments.tail.head.name == "invert")
    assert(groupedArguments.tail.head.parameters == List.empty)
  }

  test("Checking argument validity") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("image", List("exampleSMALLER.png")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    consoleView.checkArgumentListValidity(groupedArguments)
  }

  test("Checking argument validity - invalid") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("image", List.empty),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    assertThrows[Exception] {
      consoleView.checkArgumentListValidity(groupedArguments)
    }
  }

  test("Find importers") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("image", List("exampleSMALLER.png")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    val importer: Importer[RGBImage] = consoleView.findImporters(groupedArguments);
    assert(importer.getClass.getSimpleName == "RGBImageImporterFromPNG")
  }

  test("Too many importers") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("image", List("exampleSMALLER.png")),
      new ArgumentWithStringParameters("image-random", List.empty),
    )
    assertThrows[Exception] {
      consoleView.findImporters(groupedArguments);
    }
  }

  test("Find filters") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("brightness", List("1")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    val filters: Seq[ASCIIFilter] = consoleView.findFilters(groupedArguments);
    assert(filters.head.getClass.getSimpleName == "AdjustBrightnessFilter")
    assert(filters.tail.head.getClass.getSimpleName == "InvertASCIIFilter")
  }

  test("Brightness filter with non-number parameter") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("brightness", List("karel")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    assertThrows[Exception] {
      consoleView.findFilters(groupedArguments);
    }
  }

  test("Find numberToCharTransformer") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("table", List("bourke-small")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    val numberToCharTransformer: NumberToCharTransformer = consoleView.findNumberToCharTransformer(groupedArguments);
    assert(numberToCharTransformer.getClass.getSimpleName == "LinearGreyscalePixelToCharTransformer")
  }

  test("Two table arguments") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("table", List("bourke-small")),
      new ArgumentWithStringParameters("table", List("bourke-small")),
    )
    assertThrows[Exception] {
      consoleView.findNumberToCharTransformer(groupedArguments);
    }
  }

  test("Find exporters") {
    val groupedArguments: List[ArgumentWithStringParameters] = List(
      new ArgumentWithStringParameters("output-console", List.empty),
      new ArgumentWithStringParameters("output-file", List("exampleSMALLER.png")),
      new ArgumentWithStringParameters("invert", List.empty),
    )
    val exporters: Seq[ASCIIExporter] = consoleView.findExporters(groupedArguments);
    assert(exporters.head.getClass.getSimpleName == "StdOutputASCIIExporter")
    assert(exporters.tail.head.getClass.getSimpleName == "FileOutputASCIIExporter")
  }
}
