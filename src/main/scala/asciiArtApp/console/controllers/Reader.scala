package asciiArtApp.console.controllers

class Reader(
              private var registeredArguments: scala.collection.mutable.Map[String, (Int, List[String] => Argument)],
              private var registeredCategories: scala.collection.mutable.Map[String, List[String]]
            )
{
  def registerArgument(name: String, numberOfParameters: Int, constructor: List[String] => Argument): Unit = {
    registeredArguments.addOne(name, (numberOfParameters, constructor));
  }

  def registerCategory(categoryName: String, argumentNames: List[String]): Unit = {
    registeredCategories.addOne(categoryName, argumentNames);
  }

  def createArgument(unprocessedArguments: List[String], argumentName: String, index: Int): Argument = {
    val (numberOfParameters, constructor) = registeredArguments(argumentName);
    if (index + numberOfParameters > unprocessedArguments.length) {
      throw new Exception("Argument doesnt have enough parameters, " + argumentName + " should have " + numberOfParameters);
    }
    val range : Range = index until (index+numberOfParameters)
    var parameterList: List[String] = List.empty;
    parameterList = parameterList.appended(argumentName);
    for (i <- range) {
      if (unprocessedArguments(i).startsWith("--")) {
        throw new Exception("Argument doesnt have enough parameters, " + argumentName + " should have " + numberOfParameters);
      }
      parameterList = parameterList.appended(unprocessedArguments(i))
    }
    return constructor(parameterList)
  }

  def processArguments(unprocessedArguments: List[String], category: List[String]): List[Argument] = {
    var processedArguments: List[Argument] = List.empty;
    val listSize = unprocessedArguments.length;
    var index = 0;
    for (el <- unprocessedArguments) {
      if (el.startsWith("--")) {
        if (!registeredArguments.contains(el.substring(2))) {
          throw new Exception("Argument " + el.substring(2) + " is not recognized.")
        }
        if (category.contains(el.substring(2))) {
          processedArguments = processedArguments.appended(createArgument(unprocessedArguments, el.substring(2), index+1));
        }
      }
      index = index + 1;
    }
    return processedArguments;
  }

  def readAllArguments(unprocessedArguments: List[String]): List[Argument] = {
    processArguments(unprocessedArguments, registeredArguments.keys.toList)
  }

  def readArgumentOfCategory(unprocessedArguments: List[String], category: String): List[Argument] = {
    processArguments(unprocessedArguments, registeredCategories(category))
  }
}