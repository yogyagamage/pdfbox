package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.Test;

public class PDType1Fontmethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // The static initializer (<clinit>) will be triggered when the class is loaded
        // which happens when we reference PDType1Font.class in the constructor call.
        // This will execute: LogFactory.getLog(PDType1Font.class)
        new PDType1Font(FontName.HELVETICA);
    }
}
