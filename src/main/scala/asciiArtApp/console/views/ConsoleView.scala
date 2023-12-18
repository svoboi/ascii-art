package asciiArtApp.console.views

import asciiArtApp.console.controllers.Controller
import asciiArtApp.models.RGBImage
import exporters.ASCII.{ASCIIExporter, FileOutputASCIIExporter, StdOutputASCIIExporter}
import exporters.text.TextExporter
import importers.imageImporters.{RGBImageGeneratorRandom, RGBImageImporterFromJPG, RGBImageImporterFromPNG}
import importers.Importer
import transformers.ASCIIFilters._
import transformers.OneGreyscalePixelToCharTransformers.{HigherContrastGreyscalePixelToCharTransformer, LinearGreyscalePixelToCharTransformer}
import transformers.{GreyscaleToASCIIImageTransformer, NumberToCharTransformer, RGBImageToGreyscaleImage}

import java.io.File

class ConsoleView(protected val controller: Controller, protected val stdOutputExporter: TextExporter) {

  val registeredCategories: Map[String, Map[String, Int]] = Map(
    ("import", Map(
      ("image-random", 0),
      ("image", 1))),
    ("filter", Map(
      ("brightness", 1),
      ("flip", 1),
      ("invert", 0))),
    ("charTable", Map(
      ("table", 1),
      ("custom-table", 1))),
    ("export", Map(
      ("output-console", 0),
      ("output-file", 1)))
  )

  def checkArgumentListValidity(groupedArguments: List[ArgumentWithStringParameters]): Unit = {
    val registeredArguments = registeredCategories.values.flatten.toMap
    for (argument <- groupedArguments) {
      if (!registeredArguments.contains(argument.name)) {
        throw new Exception("Argument '" + argument.name + "' is not recognized.")
      }
      if (registeredArguments(argument.name) != argument.parameters.length) {
        throw new Exception("Argument '" + argument.name + "' takes " + registeredArguments(argument.name) + " parameter(s).")
      }
    }
  }

  def groupArguments(arguments: List[String]): List[ArgumentWithStringParameters] = {
    var argumentsWithParametersList: List[ArgumentWithStringParameters] = List.empty
    var argumentWithParameters: List[String] = List.empty
    for (argument <- arguments) {
      if (argument.startsWith("--")) {
        if (!argumentWithParameters.isEmpty) {
          argumentsWithParametersList = argumentsWithParametersList.appended(
            new ArgumentWithStringParameters(argumentWithParameters.head, argumentWithParameters.tail))
          argumentWithParameters = List.empty
        }
      }
      argumentWithParameters = argumentWithParameters.appended(argument.replace("--", ""))
    }
    argumentsWithParametersList = argumentsWithParametersList.appended(
      new ArgumentWithStringParameters(argumentWithParameters.head, argumentWithParameters.tail))
    return argumentsWithParametersList;
  }

  def findImporters(groupedArguments: List[ArgumentWithStringParameters]): Importer[RGBImage] = {
    var importers: List[Importer[RGBImage]] = List.empty
    for (argument <- groupedArguments) {
      argument.name match {
        case "image-random" => importers = importers.appended(new RGBImageGeneratorRandom)
        case "image" => {
          if (argument.parameters.head.endsWith("jpg")) {
            importers = importers.appended(new RGBImageImporterFromJPG(argument.parameters.head))
          }
          else if (argument.parameters.head.endsWith("png")) {
            importers = importers.appended(new RGBImageImporterFromPNG(argument.parameters.head))
          }
          else {
            throw new Exception("Unknown format!")
          }
        }
        case _ => {}
      }
    }
    if (importers.length != 1) {
      throw new Exception("Application takes exactly one importer argument, either '--image' or '--image-random'.")
    }
    importers.head;
  }

  def findFilters(groupedArguments: List[ArgumentWithStringParameters]): Seq[ASCIIFilter] = {
    var filters: Seq[ASCIIFilter] = List.empty
    for (argument <- groupedArguments) {
      argument.name match {
        case "brightness" => {
          try {
            argument.parameters.head.toInt
          }
          catch {
            case e: NumberFormatException => throw new Exception("Filter '--brightness' requires a number parameter.")
          }
          filters = filters.appended(new AdjustBrightnessFilter(argument.parameters.head.toInt))
        }
        case "flip" => {
          val axis = try {
            Axis.withName(argument.parameters.head)
          }
          catch {
            case e: Exception => throw new Exception("This direction of flip is not defined!")
          }
          filters = filters.appended(new FlipASCIIFilter(axis))
        }
        case "invert" => filters = filters.appended(new InvertASCIIFilter())
        case _ => {}
      }
    }
    filters;
  }

  def findNumberToCharTransformer(groupedArguments: List[ArgumentWithStringParameters]): NumberToCharTransformer = {
    var numberToCharTransformersList: List[NumberToCharTransformer] = List.empty;
    for (argument <- groupedArguments) {
      (argument.name, argument.parameters) match {
        case ("table", List("bourke-small")) =>
          numberToCharTransformersList = numberToCharTransformersList.appended(
            new LinearGreyscalePixelToCharTransformer(" .:-=+*#%@".toCharArray)
          )
        case ("table", List("bourke-standard")) =>
          numberToCharTransformersList = numberToCharTransformersList.appended(
            new LinearGreyscalePixelToCharTransformer(
              " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray
            ))
        case ("table", List("non-linear")) =>
          numberToCharTransformersList = numberToCharTransformersList.appended(
            new HigherContrastGreyscalePixelToCharTransformer)
        case ("custom-table", List(table: String)) =>
          numberToCharTransformersList = numberToCharTransformersList.appended(
            new LinearGreyscalePixelToCharTransformer(
              table.toCharArray
            ))
        case _ => {}
      }
    }
    if (numberToCharTransformersList.length == 1) {
      return numberToCharTransformersList.head
    }
    if (numberToCharTransformersList.isEmpty) {
      return new LinearGreyscalePixelToCharTransformer(
        " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray
      )
    }
    else {
      throw new Exception("Application takes one or none table arguments, either '--custom-table' or '--table'.")
    }
  }

  def findExporters(groupedArguments: List[ArgumentWithStringParameters]): Seq[ASCIIExporter] = {
    var exporters: Seq[ASCIIExporter] = List.empty
    for (argument <- groupedArguments) {
      argument.name match {
        case "output-console" => exporters = exporters.appended(new StdOutputASCIIExporter)
        case "output-file" => exporters = exporters.appended(new FileOutputASCIIExporter(new File(argument.parameters.head)))
        case _ => {}
      }
    }
    exporters;
  }

  def showError(message: String): Unit = {
    stdOutputExporter.exportFunc(message + "\n");
  }

  def run(arguments: List[String]): Unit = {
    try {
      val groupedArguments: List[ArgumentWithStringParameters] = groupArguments(arguments)
      checkArgumentListValidity(groupedArguments);
      val importer: Importer[RGBImage] = findImporters(groupedArguments);
      val bufferedImageToNumberImageTransformer = new RGBImageToGreyscaleImage;
      val filters: Seq[ASCIIFilter] = findFilters(groupedArguments)
      val numberToCharTransformer: NumberToCharTransformer = findNumberToCharTransformer(groupedArguments)
      val numberToCharImageTransformer = new GreyscaleToASCIIImageTransformer(numberToCharTransformer)
      val exporters: Seq[ASCIIExporter] = findExporters(groupedArguments)
      controller.importFilterExport(
        importer,
        bufferedImageToNumberImageTransformer,
        filters,
        numberToCharImageTransformer,
        exporters);
    }
    catch {
      case e: Exception => showError(e.getMessage)
    }
  }
}
