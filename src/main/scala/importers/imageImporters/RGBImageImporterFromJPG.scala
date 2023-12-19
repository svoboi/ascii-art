package importers.imageImporters

class RGBImageImporterFromJPG(protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "jpg"
}
