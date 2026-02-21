package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDocument;
import org.junit.jupiter.api.Test;

public class FDFDocument_COSDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Creating a COSDocument instance will trigger static initialization
        // which includes the LogFactory.getLog(COSDocument.class) call
        COSDocument document = new COSDocument();
    }
}
