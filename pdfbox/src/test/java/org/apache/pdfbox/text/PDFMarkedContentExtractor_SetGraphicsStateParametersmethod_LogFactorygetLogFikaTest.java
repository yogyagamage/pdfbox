package org.apache.pdfbox.text;

import org.apache.pdfbox.contentstream.operator.state.SetGraphicsStateParameters;
import org.junit.jupiter.api.Test;

class PDFMarkedContentExtractor_SetGraphicsStateParametersmethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructorTriggersStaticInitializer() {
        // Create an instance using the constructor that takes a String parameter
        // This will trigger the constructor chain leading to SetGraphicsStateParameters class initialization
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
        
        // The static initialization of SetGraphicsStateParameters will call LogFactory.getLog()
        // No assertions needed - the test passes if the constructor chain executes without throwing exceptions
    }
}
