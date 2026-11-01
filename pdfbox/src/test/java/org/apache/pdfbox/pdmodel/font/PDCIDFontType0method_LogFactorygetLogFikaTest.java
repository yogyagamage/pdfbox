package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;

class PDCIDFontType0method_LogFactorygetLogFikaTest {

    @Test
    void test() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        Class.forName("org.apache.pdfbox.pdmodel.font.PDCIDFontType0", true, classLoader);
    }
}
