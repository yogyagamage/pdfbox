package org.apache.pdfbox.text;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class PDFTextStrippermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // The static initialization of PDFTextStripper triggers LogFactory.getLog
        // when the static field LOG is initialized.
        // Creating an instance will trigger static initialization if not already done.
        PDFTextStripper stripper = new PDFTextStripper();
        
        // To ensure the static initializer runs, we can also trigger a method
        // that uses the LOG field, but just creating the instance is sufficient
        // because the class must be initialized before constructor execution.
        
        // The following call ensures the full chain is executed, including
        // the static initializer that contains LogFactory.getLog
        PDDocument document = new PDDocument();
        StringWriter writer = new StringWriter();
        stripper.writeText(document, writer);
        document.close();
    }
}
