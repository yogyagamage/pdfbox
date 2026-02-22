package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PDType0Fontmethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testLoadVerticalTriggersStaticInitializer() throws Exception {
        // Create a minimal PDDocument
        PDDocument document = new PDDocument();
        
        // Create a minimal input stream (empty TTF-like data would cause parsing errors,
        // but static initializer runs before parsing)
        byte[] emptyData = new byte[0];
        InputStream inputStream = new ByteArrayInputStream(emptyData);
        
        try {
            // This call triggers the static initializer which calls LogFactory.getLog
            PDType0Font.loadVertical(document, inputStream);
        } catch (Exception e) {
            // Expected - the font data is invalid, but static initializer already ran
        } finally {
            document.close();
            inputStream.close();
        }
    }
}
