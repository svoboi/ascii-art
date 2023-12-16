package asciiArtApp.console.views

import asciiArtApp.console.controllers.Controller
import importers.{BufferedImageGenerator, ImageImporterFromFile, Importer}
import transformers.ASCIIFilters.{ASCIIFilter, AdjustBrightnessFilter, FlipASCIIFilter, InvertASCIIFilter}
import transformers.BufferedImageToNumberImageTransformer

import java.awt.image.BufferedImage

class ConsoleView(protected val controller: Controller) {

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
        throw new Exception("Argument " + argument.name + " is not recognized.")
      }
      if (registeredArguments(argument.name) != argument.parameters.length) {
        throw new Exception("Argument " + argument.name + " takes " + registeredArguments(argument.name) + " arguments.")
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

  def findImporters(groupedArguments: List[ArgumentWithStringParameters]): Importer[BufferedImage] = {
    var importers: List[Importer[BufferedImage]] = List.empty
    for (argument <- groupedArguments) {
      argument.name match {
        case "image-random" => importers = importers.appended(new BufferedImageGenerator)
        case "image" => importers = importers.appended(new ImageImporterFromFile(argument.parameters.head))
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
          catch  {
            case e: NumberFormatException => throw new Exception("Filter '--brightness' requires a number parameter.")
          }
          filters = filters.appended(new AdjustBrightnessFilter(argument.parameters.head.toInt))
        } case "flip" => filters = filters.appended(new FlipASCIIFilter(argument.parameters.head.head))
        case "invert" => filters = filters.appended(new InvertASCIIFilter())
        case _ => {}
      }
    }
    filters;
  }

  def run(arguments: List[String]): Unit = {
    // pridat try-catch
    // zkontrolovat, jestli nevolaji jen help
    val groupedArguments: List[ArgumentWithStringParameters] = groupArguments(arguments)
    checkArgumentListValidity(groupedArguments);
    val importers: Importer[BufferedImage] = findImporters(groupedArguments);
    val bufferedImageToNumberImageTransformer = new BufferedImageToNumberImageTransformer;
    val filters: Seq[ASCIIFilter] = findFilters(groupedArguments)
//    val table: Option[NumberToCharTransformer] = findNumberToCharTransformer(groupedArguments)
//    //tady capnout nebo vyrobit numbertochartransformer, vyrobit numberimagetocharimage
//    val exporters: Seq[Exporter[BufferedImage]] = findExporters(groupedArguments)
  }
}
