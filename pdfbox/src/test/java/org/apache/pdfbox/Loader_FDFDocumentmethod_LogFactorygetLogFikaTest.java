package org.apache.pdfbox;

import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.util.XMLUtil;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Loader_FDFDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadXFDFTriggersLogFactoryGetLog() throws Exception {
        // Create a minimal XML input stream to trigger FDFDocument class initialization
        String xmlContent = "<?xml version=\"1.0\"?><xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\"></xfdf>";
        InputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());
        
        // This call will trigger:
        // 1. Loader.loadXFDF(inputStream)
        // 2. FDFDocument class initialization (static initializer)
        // 3. LogFactory.getLog(FDFDocument.class) in FDFDocument's static field initialization
        Loader.loadXFDF(inputStream);
    }
}
