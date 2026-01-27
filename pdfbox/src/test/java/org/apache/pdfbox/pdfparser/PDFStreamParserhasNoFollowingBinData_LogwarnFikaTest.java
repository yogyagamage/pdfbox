package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorName;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class PDFStreamParserhasNoFollowingBinData_LogwarnFikaTest {

    @Test
    void testParseNextTokenTriggersLogWarn() throws IOException {
        // Create a content stream that will cause parseNextToken to eventually call hasNoFollowingBinData
        // which will trigger LOG.warn. We need to simulate a scenario where:
        // 1. parseNextToken encounters 'I' and reads "ID"
        // 2. Then reads until "EI" followed by space/return
        // 3. Then hasNoFollowingBinData returns false, triggering LOG.warn
        
        // Build a byte array that represents: "ID" + image data + "EI" + something that makes hasNoFollowingBinData return false
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Write "ID"
        baos.write('I');
        baos.write('D');
        // Skip whitespace (as per parseNextToken logic)
        baos.write(' ');
        // Write some image data bytes
        for (int i = 0; i < 10; i++) {
            baos.write(0x41); // 'A'
        }
        // Write "EI"
        baos.write('E');
        baos.write('I');
        // Write a space (so hasNextSpaceOrReturn returns true)
        baos.write(' ');
        // Write bytes that will make hasNoFollowingBinData return false:
        // We need control characters or > 0x7f, or a non-allowed operator
        // Let's use a control character: 0x01
        baos.write(0x01);
        // Add more bytes to fill the buffer
        for (int i = 0; i < 9; i++) {
            baos.write(0x42); // 'B'
        }
        
        byte[] contentBytes = baos.toByteArray();
        PDFStreamParser parser = new PDFStreamParser(contentBytes);
        
        // Call parseNextToken which should eventually trigger the log warn
        parser.parseNextToken();
    }
}
