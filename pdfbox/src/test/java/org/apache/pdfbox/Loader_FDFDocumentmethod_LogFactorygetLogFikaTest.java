package org.apache.pdfbox;

import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.util.XMLUtil;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Loader_FDFDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadXFDFTriggersLogFactoryGetLog() throws Exception {
        // Create a minimal valid XFDF input stream
        String xfdfContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\"></xfdf>";
        InputStream inputStream = new ByteArrayInputStream(xfdfContent.getBytes());
        
        // This will trigger the static initialization of FDFDocument,
        // which calls LogFactory.getLog(FDFDocument.class)
        Loader.loadXFDF(inputStream);
    }
}
