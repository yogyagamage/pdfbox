package org.apache.pdfbox.pdmodel.fixup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;

class AcroFormDefaultFixup_AcroFormOrphanWidgetsProcessormethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        PDDocument document = new PDDocument();
        PDAcroForm acroForm = new PDAcroForm(document);
        
        // The static field initialization will trigger LogFactory.getLog
        // when the class is loaded. We just need to trigger class loading.
        Class<?> clazz = Class.forName("org.apache.pdfbox.pdmodel.fixup.processor.AcroFormOrphanWidgetsProcessor");
        
        document.close();
    }
}
