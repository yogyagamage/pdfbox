package org.apache.pdfbox.rendering;

import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class PageDrawer_TilingPaintFactorymethod_LogFactorygetLogFikaTest {

    @Test
    public void test() {
        try {
            Class<?> clazz = Class.forName("org.apache.pdfbox.rendering.TilingPaintFactory");
            LogFactory.getLog(clazz);
        } catch (Throwable ignored) {
        }
        try {
            LogFactory.getLog(TilingPaintFactory.class);
        } catch (Throwable ignored) {
        }
    }
}
