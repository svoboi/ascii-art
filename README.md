# ASCII Art

This tool offers a way to transform images to ASCII ART images. 
It currently accepts JPG and PNG formats and returns a text file.
Pictures are a bit elongated, since characters aren't square and this project uses one character for one pixel.

## Command line arguments

### Source of Image
1. File: "--image [path to file]"
2. Randomly generated: "--image-random"

### Filters
1. Brightness correction: "--brightness [number]"
2. Flip on X or Y axis or both : "--flip [X/Y/D]"
3. Invert colours: "--invert"

### Output destination
1. File: "--output-file [path to file]"
2. Console: "--output-console"

### Used characters
Both bourke-small and bourke-standard tables are creation of Paul Bourke: http://www.paulbourke.net/dataformats/asciiart/
1. Smaller selection: "--table bourke-small"
2. Standard Bourke table: --table bourke-standard
3. Higher contrast: "--table non-linear"
4. Custom character selection: "--custom-table [character list]"

## Examples
Files that are in examples/output are generated with following commands from files in examples/input.

--image examples/input/grapes.jpg --table bourke-small --brightness 20 --output-file examples/output/grapes.txt  
--image "examples/input/line dragon spaces in name.jpg" --custom-table " .:*O#@" --output-file "examples/output/line dragon.txt"  
--image examples/input/line-apple.png --table bourke-small --flip Y --output-file examples/output/line-apple-flipped.txt  
--image examples/input/line-apple.png --table bourke-small --invert --output-file examples/output/line-apple-inverted.txt  
--image examples/input/tiger.jpg --table bourke-standard --output-file examples/output/tiger-linear.txt  
--image examples/input/tiger.jpg --table non-linear --output-file examples/output/tiger-nonlinear.txt  
--image examples/input/tiger.jpg --table non-linear --output-file examples/output/tiger-nonlinear-less-bright.txt --brightness -20  

#### Generating random characters
--image-random --table non-linear --output-console  

#### Unreadable file
--image examples/input/txtrenamedtopng.png --custom-table " .:*O#@" --output-console  

#### File in unsupported format
--image "examples/input/xml.xml" --custom-table " .:*O#@" --output-console  