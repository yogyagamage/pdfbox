package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.Test;

public class PDType1Font_PDSimpleFontmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // This will trigger the static initializer of PDSimpleFont
        // which calls LogFactory.getLog(PDSimpleFont.class)
        new PDType1Font(FontName.HELVETICA);
    }
}
