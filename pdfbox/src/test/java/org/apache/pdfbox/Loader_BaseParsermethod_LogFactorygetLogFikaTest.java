package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Loader_BaseParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadFDFTriggersBaseParserStaticInitializer() throws Exception {
        // Create minimal FDF data to trigger parser initialization
        String fdfData = "%FDF-1.2\n" +
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
        
        InputStream input = new ByteArrayInputStream(fdfData.getBytes());
        
        // This call will trigger BaseParser.<clinit>() which calls LogFactory.getLog()
        Loader.loadFDF(input);
    }
}
