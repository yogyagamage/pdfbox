package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class PDObjectStream_PDStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            COSStream cosStream = document.getDocument().createCOSStream();
            new PDStream(cosStream);
        }
    }
}
