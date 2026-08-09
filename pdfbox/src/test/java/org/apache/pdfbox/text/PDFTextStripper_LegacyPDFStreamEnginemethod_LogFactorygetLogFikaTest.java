package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.StringWriter;

public class PDFTextStripper_LegacyPDFStreamEnginemethod_LogFactorygetLogFikaTest {

    @Test
    public void testConstructorTriggersStaticInitializer() throws Exception {
        // Create a real PDDocument to satisfy any potential dependencies
        PDDocument document = new PDDocument();
        
        // Instantiate PDFTextStripper using the provided constructor
        // This will trigger the static initializer chain in LegacyPDFStreamEngine
        // which includes the call to LogFactory.getLog(LegacyPDFStreamEngine.class)
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Clean up
        document.close();
    }
}
