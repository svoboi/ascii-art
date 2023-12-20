package asciiArtApp.console.views

import asciiArtApp.console.views.parsers._
import asciiArtApp.controllers.Controller
import asciiArtApp.models.RGBImage
import exporters.text.TextExporter
import importers.Importer
import transformers.ASCIIFilters._
import transformers.OneGreyscalePixelToCharTransformers.LinearGreyscalePixelToCharTransformer
import transformers.{ASCIIImageToStringTransformer, GreyscaleToASCIIImageTransformer, NumberToCharTransformer, RGBImageToGreyscaleImage}

/**
 * The ConsoleView class manages the interaction between the user input, the application controller,
 * and the output exporters. It initializes various parsers for different functionalities and
 * orchestrates the execution based on the parsed command line arguments.
 *
 * @param controller        The application controller for managing image processing operations.
 * @param stdOutputExporter The text exporter for displaying errors on the standard console.
 */
class ConsoleView(protected val controller: Controller, protected val stdOutputExporter: TextExporter) {
  val brightnessParser = new BrightnessParser
  val customTableParser = new CustomTableParser
  val flipParser = new FlipParser
  val imageGeneratorParser = new ImageGeneratorParser
  val imageImporterParser = new ImageImporterParser
  val invertParser = new InvertParser
  val outputConsoleParser = new OutputConsoleParser
  val outputFileParser = new OutputFileParser
  val tableParser = new TableParser

  def groupArguments(arguments: List[String]): List[List[String]] = {
    var groupedArguments: List[List[String]] = List.empty
    var argumentWithParameters: List[String] = List.empty
    for (argument <- arguments) {
      if (argument.startsWith("--")) {
        if (argumentWithParameters.nonEmpty) {
          groupedArguments = groupedArguments.appended(argumentWithParameters)
          argumentWithParameters = List.empty
        }
      }
      argumentWithParameters = argumentWithParameters.appended(argument.replace("--", ""))
    }
    groupedArguments = groupedArguments.appended(argumentWithParameters)
    return groupedArguments;
  }

  protected def showError(message: String): Unit = {
    stdOutputExporter.exportFunc(message + "\n");
  }

  def run(arguments: List[String]): Unit = {
    try {
      val groupedArguments: List[List[String]] = groupArguments(arguments)
      var importers: List[Importer[RGBImage]] = List.empty;
      var filters: List[ASCIIFilter] = List.empty;
      var numberToCharTransformers: List[NumberToCharTransformer] = List.empty;
      var exporters: List[TextExporter] = List.empty;

      for (argument <- groupedArguments) {
        argument.head match {
          case "image" =>
            importers = importers.appended(imageImporterParser.parse(argument));
          case "image-random" =>
            importers = importers.appended(imageGeneratorParser.parse(argument));
          case "table" =>
            numberToCharTransformers = numberToCharTransformers.appended(tableParser.parse(argument));
          case "custom-table" =>
            numberToCharTransformers = numberToCharTransformers.appended(customTableParser.parse(argument));
          case "brightness" =>
            filters = filters.appended(brightnessParser.parse(argument));
          case "flip" =>
            filters = filters.appended(flipParser.parse(argument));
          case "invert" =>
            filters = filters.appended(invertParser.parse(argument));
          case "output-console" =>
            exporters = exporters.appended(outputConsoleParser.parse(argument));
          case "output-file" =>
            exporters = exporters.appended(outputFileParser.parse(argument));
          case _ => throw new IllegalArgumentException("Argument '" + argument.head + "' is not recognized.")
        }
      }

      if (importers.length != 1) {
        throw new IllegalArgumentException("Application takes exactly one importer argument, either '--image' or '--image-random'.")
      }
      if (numberToCharTransformers.length > 1) {
        throw new IllegalArgumentException("Application takes one or none table arguments, either '--custom-table' or '--table'.")
      }
      if (numberToCharTransformers.isEmpty) {
        numberToCharTransformers = numberToCharTransformers.appended(new LinearGreyscalePixelToCharTransformer(" .:-=+*#%@".toCharArray))
      }

      val bufferedImageToNumberImageTransformer = new RGBImageToGreyscaleImage;
      val numberToCharImageTransformer = new GreyscaleToASCIIImageTransformer(numberToCharTransformers.head)
      val asciiImageToStringTransformer = new ASCIIImageToStringTransformer

      controller.importFilterExport(
        importers.head,
        bufferedImageToNumberImageTransformer,
        filters,
        numberToCharImageTransformer,
        asciiImageToStringTransformer,
        exporters);
    }
    catch {
      case e: Exception => showError(e.getMessage)
    }
  }
}
