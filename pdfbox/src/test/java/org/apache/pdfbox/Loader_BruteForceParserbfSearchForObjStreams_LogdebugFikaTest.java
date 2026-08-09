package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Loader_BruteForceParserbfSearchForObjStreams_LogdebugFikaTest {

    @TempDir
    Path tempDir;

    @Test
    public void testLoadFDFTriggersLogDebug() throws IOException {
        // Create a minimal valid FDF file that will trigger the bfSearchForObjStreams path
        File fdfFile = tempDir.resolve("test.fdf").toFile();
        
        // FDF header and minimal content that will cause the parser to attempt brute force search
        String fdfContent = "%FDF-1.2\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/FDF << /F (test.pdf) >>\n" +
                ">>\n" +
                "endobj\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 1 0 R\n" +
                ">>\n" +
                "%%EOF";
        
        try (FileOutputStream fos = new FileOutputStream(fdfFile)) {
            fos.write(fdfContent.getBytes());
        }
        
        // This call should traverse through the entire chain:
        // Loader.loadFDF(String) -> Loader.loadFDF(File) -> FDFParser.parse() -> 
        // FDFParser.initialParse() -> COSParser.retrieveTrailer() -> 
        // BruteForceParser.bfSearchForObjStreams() -> Log.debug()
        Loader.loadFDF(fdfFile.getAbsolutePath());
    }
}
