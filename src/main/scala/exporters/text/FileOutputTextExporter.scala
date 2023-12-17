package exporters.text

import java.io.{File, FileOutputStream}

//source: Martin Drozdik, CTU class OOP, labs

class FileOutputTextExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file)) {

}
