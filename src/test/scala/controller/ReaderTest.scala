package controller

import asciiArtApp.console.controllers.{Argument, ArgumentWithStringParameter, ArgumentWithoutParameter, Reader}
import org.scalatest.FunSuite

class ReaderTest extends FunSuite {

  val reader = new Reader(
    scala.collection.mutable.Map.empty[String, (Int, List[String] => Argument)],
    scala.collection.mutable.Map.empty[String, List[String]]
  );

  test("Correct with image path") {
    reader.registerArgument(
      "image",
      1,
      { (arguments: List[String]) => new ArgumentWithStringParameter("input", "image", arguments.head) }
    )
    val input = List[String]("--image", "exampleSMALLER.png")
    val arguments = reader.readAllArguments(input)
    assert(arguments.head.name == "image")
  }

  test("Wrong, missing image path") {
    reader.registerArgument(
      "image",
      1,
      { (arguments: List[String]) => new ArgumentWithStringParameter("input", "image", arguments.head) }
    )
    val input = List[String]("--image")
    assertThrows[Exception] {
      val arguments = reader.readAllArguments(input)
    }
  }

  test("Wrong, missing image path with next argument") {
    reader.registerArgument(
      "image",
      1,
      { (arguments: List[String]) => new ArgumentWithStringParameter("input", "image", arguments.head) }
    )
    val input = List[String]("--image --nextArgument")
    assertThrows[Exception] {
      val arguments = reader.readAllArguments(input)
    }
  }

  test("Correct with image path with source as category") {
    reader.registerCategory("source", List[String]("image"))
    reader.registerArgument(
      "image",
      1,
      { (arguments: List[String]) => new ArgumentWithStringParameter("input", "image", arguments.head) }
    )
    reader.registerArgument(
      "whateverArgument",
      0,
      { (arguments) => {new ArgumentWithoutParameter("whateverArgument", "whateverArgument")}}
    )
    val input = List[String]("--image", "exampleSMALLER.png", "--whateverArgument")
    val arguments = reader.readArgumentOfCategory(input, "source")
    assert(arguments.head.name == "image")
  }

}
