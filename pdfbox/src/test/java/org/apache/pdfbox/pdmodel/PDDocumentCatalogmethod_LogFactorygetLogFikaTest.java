package org.apache.pdfbox.pdmodel;

import org.junit.jupiter.api.Test;

public class PDDocumentCatalogmethod_LogFactorygetLogFikaTest {

    @Test
    public void testPDDocumentCatalogStaticInitializationInvokesLogFactoryGetLog() throws Exception {
        Class.forName("org.apache.pdfbox.pdmodel.PDDocumentCatalog", true, getClass().getClassLoader());
    }
}
