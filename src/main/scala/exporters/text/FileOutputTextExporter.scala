package exporters.text

import java.io.{File, FileOutputStream}


/**
 * The FileOutputTextExporter class extends the StreamTextExporter to export text-based content to a file.
 * @param file The File where the text content will be exported.
 * @author Martin Drozdik, course OOP on CTU, https://courses.fit.cvut.cz/BI-OOP
 */
class FileOutputTextExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file)) {

}
