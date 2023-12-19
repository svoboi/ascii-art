package asciiArtApp.console.views

import asciiArtApp.controllers.ConsoleController
import exporters.text.StdOutputTextExporter
import org.scalatest.FunSuite

class ConsoleViewTest extends FunSuite {
  val consoleView: ConsoleView = new ConsoleView(new ConsoleController, new StdOutputTextExporter)

  test("Grouping arguments") {
    val arguments = List("--image", "exampleSMALLER.png", "--invert")
    val groupedArguments = consoleView.groupArguments(arguments)
    assert(groupedArguments.head(0) == "image")
    assert(groupedArguments.head(1) == "exampleSMALLER.png")
    assert(groupedArguments.tail.head(0) == "invert")
  }

}
