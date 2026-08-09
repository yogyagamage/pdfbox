package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdfparser.FDFParser;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;

public class Loader_BruteForceParserbfSearchForTrailer_LogdebugFikaTest {
    
    @TempDir
    File tempDir;
    
    @Test
    public void testLoadFDFTriggersLogDebug() throws IOException {
        // Create a minimal FDF file that will trigger the brute force search path
        File fdfFile = new File(tempDir, "test.fdf");
        
        // Create a simple FDF file without proper xref table to trigger rebuildTrailer
        try (FileOutputStream fos = new FileOutputStream(fdfFile)) {
            // Write FDF header
            fos.write("%FDF-1.2\n".getBytes());
            fos.write("%\u00e2\u00e3\u00cf\u00d3\n".getBytes());
            
            // Write some content but no proper xref/trailer
            fos.write("1 0 obj\n".getBytes());
            fos.write("<< /Type /FDF >>\n".getBytes());
            fos.write("endobj\n".getBytes());
            
            // Write trailer without proper xref
            fos.write("trailer\n".getBytes());
            fos.write("<< /Root 1 0 R >>\n".getBytes());
            fos.write("startxref\n".getBytes());
            fos.write("0\n".getBytes());
            fos.write("%%EOF\n".getBytes());
        }
        
        // This will trigger the call chain:
        // Loader.loadFDF() -> FDFParser.parse() -> FDFParser.initialParse() -> 
        // COSParser.retrieveTrailer() -> BruteForceParser.rebuildTrailer() -> 
        // BruteForceParser.bfSearchForTrailer() -> Log.debug()
        try {
            FDFDocument document = Loader.loadFDF(fdfFile);
            if (document != null) {
                document.close();
            }
        } catch (IOException e) {
            // Expected - the file is malformed and will trigger the brute force search
            // which may throw exceptions that get logged via Log.debug()
        }
    }
}
