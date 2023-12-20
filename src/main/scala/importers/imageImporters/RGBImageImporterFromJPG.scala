package importers.imageImporters

class RGBImageImporterFromJPG(override protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "jpg"
}
