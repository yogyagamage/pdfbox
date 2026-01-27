package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Loader_BaseParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadFDFTriggersBaseParserStaticInitializer() throws IOException {
        // Create a minimal valid FDF input stream
        String fdfContent = "%FDF-1.2\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/FDF << /Fields [] >>\n" +
                ">>\n" +
                "endobj\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 1 0 R\n" +
                ">>\n" +
                "%%EOF";
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fdfContent.getBytes());
        
        // This call will trigger the static initializer of BaseParser
        // which contains LogFactory.getLog(BaseParser.class)
        FDFDocument document = Loader.loadFDF(inputStream);
        
        // Close the document to release resources
        document.close();
    }
}
