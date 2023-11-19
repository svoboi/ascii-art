package exporters.ASCII

import java.io.{File, FileOutputStream}

class FileOutputASCIIExporter (file: File)
  extends StreamASCIIExporter(new FileOutputStream(file)) {

}
