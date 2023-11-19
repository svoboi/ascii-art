package exporters.text

import java.io.{File, FileOutputStream}

class FileOutputTextExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file)) {

}
