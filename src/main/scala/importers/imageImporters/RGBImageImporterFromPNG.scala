package importers.imageImporters

/**
 * The RGBImageImporterFromPNG class extends the RGBImageImporterFromFile trait
 * for importing RGBImage specifically from PNG files.
 *
 * @param source The file path of the PNG file to be imported.
 */
class RGBImageImporterFromPNG(override protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "png"
}
