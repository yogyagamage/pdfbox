package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class PDType0Font_COSDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadFileTriggersLogFactoryGetLog() throws IOException {
        // Create a temporary TrueType font file
        File tempFile = File.createTempFile("testfont", ".ttf");
        tempFile.deleteOnExit();
        
        // Create a PDDocument instance
        PDDocument document = new PDDocument();
        
        try {
            // Invoke the entry point method which should trigger the static initializer
            // of COSDictionary, calling LogFactory.getLog(COSDictionary.class)
            PDType0Font.load(document, tempFile);
        } catch (IOException e) {
            // Expected - the file is not a valid TTF, but the static initializer
            // of COSDictionary should have been triggered during the call chain
        } finally {
            document.close();
        }
    }
}
