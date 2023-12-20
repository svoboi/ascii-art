package transformers

import asciiArtApp.models.ASCIIImage
import org.scalatest.FunSuite

class ASCIIImageToStringTransformerTest extends FunSuite {
  val transformer = new ASCIIImageToStringTransformer

  test("Success") {
    val art: ASCIIImage = new ASCIIImage(Seq(Seq('a'), Seq('d', 'e')))
    val string = transformer.transform(art)
    assert(string(0) == 'a')
    assert(string(1) == '\n')
    assert(string(2) == 'd')
  }

}
