package asciiArtApp.console.views.parsers

trait Parser[T] {

  def parse(arguments: Seq[String]): T

}
