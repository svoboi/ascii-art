package models

class SymbolASCIIArt(val pixels: List[List[Char]]) {
  val height: Int = pixels.length;
  val width: Int = pixels.head.length;
}
