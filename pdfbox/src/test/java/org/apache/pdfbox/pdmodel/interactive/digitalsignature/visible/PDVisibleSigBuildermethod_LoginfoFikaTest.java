package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDVisibleSigBuildermethod_LoginfoFikaTest {

    @Test
    public void testConstructorCallsLogInfo() {
        // The constructor has no parameters, so we can instantiate directly
        // This will execute the constructor which calls LOG.info()
        new PDVisibleSigBuilder();
    }
}
