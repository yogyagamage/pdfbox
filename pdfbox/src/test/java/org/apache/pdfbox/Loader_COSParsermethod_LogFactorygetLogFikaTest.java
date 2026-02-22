package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Loader_COSParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadFDFTriggersLogFactoryGetLog() throws Exception {
        // Create minimal FDF content to trigger COSParser class initialization
        String fdfContent = "%FDF-1.0\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/FDF << /F (test.fdf) >>\n" +
                ">>\n" +
                "endobj\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 1 0 R\n" +
                ">>\n" +
                "%%EOF";
        
        InputStream input = new ByteArrayInputStream(fdfContent.getBytes());
        
        try {
            // This will trigger COSParser.<clinit>() which calls LogFactory.getLog()
            Loader.loadFDF(input);
        } catch (Exception e) {
            // Expected - the FDF content is incomplete for full parsing
            // but COSParser class initialization already happened
        }
    }
}
