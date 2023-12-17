package asciiArtApp.console

import asciiArtApp.console.controllers.ConsoleController
import asciiArtApp.console.views.ConsoleView

object Main extends App {
  val example1 = List("--image", "side-eye-smaller.jpg", "--table", "non-linear", "--brightness", "100", "--output-console")
  //  example1 : run --image "examples/side-eye-smaller.jpg" --table non-linear --brightness 100 --output-console

  val example2 = List("--image", "planet-smaller.png",  "--table", "bourke-small", "--output-console")
  //  example2 : run --image "examples/planet-smaller.png" --table bourke-small --output-console

  //  example3 : run --image "examples/pikachu.png" --flip x --table bourke-small --output-console
  //  example4 : run --image "examples/pikachu.png" --invert --table bourke-small --output-console
  //  example5 : run --image "examples/tiger.png" --table bourke-standard --output-file tiger.txt --brightness -20
  //  example6 : run --image "examples/tiger.png" --table non-linear --output-file examples/tiger-nonlinear.txt --brightness -20
  //  example6 : run --image "examples/planet with whitespace.png" --custom-table " .:*O#@" --output-console


  val consoleView = new ConsoleView(new ConsoleController)
  consoleView.run(args.toList)


}
