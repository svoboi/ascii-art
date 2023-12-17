package importers

import java.awt.image.BufferedImage
import java.io.File
import scala.collection.mutable

class ImageImporterFromFile(protected val source: String) extends ImporterFromSource[String, BufferedImage]{
  private val formatToImporterMap = mutable.Map[String, (File => BufferedImage)]()

  override def importFunc(): BufferedImage = {
    var extension = ""
    val i = source.lastIndexOf('.')
    if (i > 0) {
      extension = source.substring(i + 1);
    }
    if (formatToImporterMap.contains(extension)) {
      return formatToImporterMap(extension)(new File(source))
    }
    throw new Exception("Unknown format.")
  }

  def registerExtensions(extensions: Seq[String], importFunction : (File => BufferedImage)): Unit = {
    for (extension <- extensions) {
      formatToImporterMap(extension) = importFunction
    }
  }
}
