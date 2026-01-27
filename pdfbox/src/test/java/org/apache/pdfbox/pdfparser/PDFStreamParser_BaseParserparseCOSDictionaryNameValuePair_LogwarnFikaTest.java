package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

class PDFStreamParser_BaseParserparseCOSDictionaryNameValuePair_LogwarnFikaTest {

    @Test
    void testParseNextTokenTriggersLogWarn() throws IOException {
        // Create a content stream that will cause parseNextToken() to call 
        // parseCOSDictionary(true), which will then call parseCOSDictionaryNameValuePair()
        // with an empty COSName, triggering LOG.warn()
        byte[] streamData = "<< / >>".getBytes(); // Dictionary with empty name
        
        // Use the byte[] constructor to avoid needing a real PDContentStream
        PDFStreamParser parser = new PDFStreamParser(streamData);
        
        // This should trigger the call chain:
        // parseNextToken() -> parseCOSDictionary(true) -> parseCOSDictionaryNameValuePair() -> Log.warn()
        parser.parseNextToken();
    }
}
