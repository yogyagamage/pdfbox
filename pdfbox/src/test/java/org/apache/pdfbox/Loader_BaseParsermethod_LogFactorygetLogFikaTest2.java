package org.apache.pdfbox;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdfparser.BaseParser;
import java.lang.reflect.Field;

public class Loader_BaseParsermethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Access the static LOG field to trigger static initialization
        Field logField = BaseParser.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        logField.get(null);
    }
}
