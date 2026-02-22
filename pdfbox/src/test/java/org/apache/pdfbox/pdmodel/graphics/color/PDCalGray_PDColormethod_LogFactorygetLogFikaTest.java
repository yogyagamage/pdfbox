package org.apache.pdfbox.pdmodel.graphics.color;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDCalGray_PDColormethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // The static initialization of PDColor will trigger LogFactory.getLog
        // when PDCalGray constructor is called
        new PDCalGray();
    }
}
