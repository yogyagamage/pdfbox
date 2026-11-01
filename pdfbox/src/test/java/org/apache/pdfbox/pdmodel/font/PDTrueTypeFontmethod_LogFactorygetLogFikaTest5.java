package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;

public class PDTrueTypeFontmethod_LogFactorygetLogFikaTest5 {

    @Test
    public void testLogFactoryGetLogDuringStaticInitialization() {
        try {
            Class.forName(PDTrueTypeFont.class.getName(), true, PDTrueTypeFont.class.getClassLoader());
        } catch (Throwable ignored) {
        }
    }
}
