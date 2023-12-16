package asciiArtApp.console

import asciiArtApp.console.controllers.ConsoleController
import asciiArtApp.console.views.ConsoleView

object Main extends App {
  val arguments: List[String] = List("--image", "side-eye.jpg", "--table", "non-linear", "--brightness", "100", "--output-console")
  val arguments2: List[String] = List("--image", "side-eye.jpg", "--table", "bourke-small", "--output-console")
  val consoleView = new ConsoleView(new ConsoleController)
  consoleView.run(arguments)


}
