package org.apache.pdfbox.contentstream.operator.graphics;

import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

class LineTomethod_LogFactorygetLogFikaTest {
    @Test
    void test() throws Exception {
        Class.forName("org.apache.pdfbox.contentstream.operator.graphics.LineTo", true, getClass().getClassLoader());
        LogFactory.getLog(LineTo.class);
    }
}
