package org.apache.pdfbox.pdmodel.fixup;

import org.apache.pdfbox.pdmodel.fixup.processor.AcroFormGenerateAppearancesProcessor;
import org.junit.jupiter.api.Test;

public class AcroFormDefaultFixup_AcroFormGenerateAppearancesProcessormethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Creating an instance will trigger static initialization
        // which calls LogFactory.getLog(AcroFormGenerateAppearancesProcessor.class)
        new AcroFormGenerateAppearancesProcessor(null);
    }
}
