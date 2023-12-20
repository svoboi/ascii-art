package asciiArtApp.console

import asciiArtApp.console.views.ConsoleView
import asciiArtApp.controllers.ConsoleController
import exporters.text.StdOutputTextExporter

object Main extends App {
  //  example1 : run --image "examples/side-eye-smaller.jpg" --table non-linear --brightness 100 --output-console
  //  example2 : run --image "examples/planet-smaller.png" --table bourke-small --output-console
  //  example3 : run --image "examples/pikachu.png" --flip x --table bourke-small --output-console
  //  example4 : run --image "examples/pikachu.png" --invert --table bourke-small --output-console
  //  example5 : run --image "examples/tiger.png" --table bourke-standard --output-file examples/tiger.txt --brightness -20
  //  example6 : run --image "examples/tiger.png" --table non-linear --output-file examples/tiger-nonlinear.txt --brightness -20
  //  example7 : run --image "examples/planet with whitespace.png" --custom-table " .:*O#@" --output-console
  //  example8 : run --image "examples/txtrenamedtopng.png" --custom-table " .:*O#@" --output-console
  //  example9 : run --image-random --custom-table " .:*O#@" --output-console
  //  example10 : run --image "examples/planet-smaller.xml" --custom-table " .:*O#@" --output-console

  val consoleView = new ConsoleView(new ConsoleController, new StdOutputTextExporter)
  consoleView.run(args.toList)

}
