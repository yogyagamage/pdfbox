package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.Test;

class PDType1Fontmethod_LogFactorygetLogFikaTest {

    @Test
    void testEntryPointToThirdPartyMethod() {
        FontName fontName = FontName.HELVETICA;
        PDType1Font font = new PDType1Font(fontName);
    }
}
