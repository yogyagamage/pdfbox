package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFStreamParser_BaseParserdecodeBuffer_LogdebugFikaTest {

    @Test
    public void testParseNextTokenTriggersLogDebug() throws IOException {
        // Create a byte array that will cause parseNextToken to call parseCOSName
        // which will then call decodeBuffer with data that causes CharacterCodingException
        // The bytes represent: "/NameWithInvalidUTF8#XX" where #XX is hex escape
        // We'll use bytes that are invalid UTF-8 to trigger the CharacterCodingException
        byte[] contentBytes = "/Test#FF".getBytes();
        
        // Create PDFStreamParser using byte array constructor
        PDFStreamParser parser = new PDFStreamParser(contentBytes);
        
        // Call parseNextToken - this should eventually trigger Log.debug
        // when decodeBuffer encounters CharacterCodingException
        parser.parseNextToken();
    }
}
