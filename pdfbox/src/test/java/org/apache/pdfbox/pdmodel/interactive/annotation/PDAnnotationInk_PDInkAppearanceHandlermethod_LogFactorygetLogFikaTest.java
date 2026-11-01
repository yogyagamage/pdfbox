package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class PDAnnotationInk_PDInkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void test() throws Exception {
        Class<?> clazz = Class.forName(
                "org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDInkAppearanceHandler",
                false,
                getClass().getClassLoader());

        LogFactory.getLog(clazz);

        Class.forName(
                "org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDInkAppearanceHandler",
                true,
                getClass().getClassLoader());
    }
}
