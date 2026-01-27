package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class PDFStreamParser_BaseParserparseCOSName_LogerrorFikaTest {

    @Test
    void testParseNextTokenInvokesLogError() throws IOException {
        // Create a byte array that will cause parseCOSName to reach the error condition
        // We need a '/' to start a name, followed by '#', then EOF before two hex digits
        byte[] inputBytes = new byte[] {'/', '#'};
        
        // Use the byte array constructor
        PDFStreamParser parser = new PDFStreamParser(inputBytes);
        
        // Call parseNextToken which should eventually call parseCOSName
        // The parseCOSName method will encounter premature EOF when trying
        // to read two hex digits after '#', triggering LOG.error
        parser.parseNextToken();
    }
}
