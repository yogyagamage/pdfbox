package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;

class FDFDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Creating an instance of FDFDictionary will trigger static initialization
        // which calls LogFactory.getLog(FDFDictionary.class)
        new FDFDictionary();
    }

}
