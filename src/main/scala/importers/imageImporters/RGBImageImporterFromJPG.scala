package importers.imageImporters

/**
 * The RGBImageImporterFromJPG class extends the RGBImageImporterFromFile trait
 * for importing RGBImage specifically from JPEG (JPG) files.
 *
 * @param source The file path of the JPEG file to be imported.
 */
class RGBImageImporterFromJPG(override protected val source: String) extends RGBImageImporterFromFile {
  protected val allowedExtension = "jpg"
}
