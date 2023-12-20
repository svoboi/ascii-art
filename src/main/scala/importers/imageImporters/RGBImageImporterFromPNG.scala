package importers.imageImporters

class RGBImageImporterFromPNG(override protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "png"
}
