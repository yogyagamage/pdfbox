package org.apache.pdfbox;

import org.apache.pdfbox.pdfparser.BaseParser;
import org.junit.jupiter.api.Test;

public class Loader_BaseParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testTriggerLogFactoryGetLog() throws Exception {
        // Accessing the static field LOG will trigger the static initializer
        // which contains the LogFactory.getLog(BaseParser.class) call
        Class<?> clazz = BaseParser.class;
        
        // Force class initialization to trigger static field initialization
        Class.forName(clazz.getName(), true, clazz.getClassLoader());
    }
}
