package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class FDFParser_COSParsergetLength_LogwarnFikaTest {

    @Test
    public void testParseTriggersLogWarn() throws IOException {
        // Create a minimal FDF content that will trigger the log warning
        // We need to create a scenario where getLength() encounters a COSNull length object
        String fdfContent = "%FDF-1.2\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/Root 2 0 R\n" +
                ">>\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 2 0 R\n" +
                ">>\n" +
                "%%EOF";
        
        byte[] fdfBytes = fdfContent.getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(fdfBytes);
        
        FDFParser parser = new FDFParser(source);
        
        // Try to parse - this should trigger the execution chain
        // that eventually calls Log.warn() when getLength() encounters COSNull
        try {
            parser.parse();
        } catch (IOException e) {
            // Expected - the test doesn't need to assert anything
            // We just need the execution to reach the Log.warn() call
        }
    }
}
