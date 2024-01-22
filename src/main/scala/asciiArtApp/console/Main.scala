package asciiArtApp.console

import asciiArtApp.console.views.ConsoleView
import asciiArtApp.controllers.ConsoleController
import exporters.text.StdOutputTextExporter

object Main extends App {

  val consoleView = new ConsoleView(new ConsoleController, new StdOutputTextExporter)
  consoleView.run(args.toList)

}
