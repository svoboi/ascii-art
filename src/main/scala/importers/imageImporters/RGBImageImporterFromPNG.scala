package importers.imageImporters

class RGBImageImporterFromPNG(protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "png"
}
