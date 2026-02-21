package org.apache.pdfbox;

import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.Test;

public class Loader_COSParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Access the static field LOG which triggers LogFactory.getLog(COSParser.class)
        // during class initialization
        Class<COSParser> clazz = COSParser.class;
        
        // Force class initialization if not already done
        Class.forName(clazz.getName());
    }
}
