package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class FDFParser_BruteForceParserbfSearchForXRefStreams_LogdebugFikaTest {

    @Test
    public void testParseToLogDebug() throws IOException {
        // Create a minimal FDF file content that will trigger the call chain
        // The content needs to be valid enough to pass initial header check
        // but cause the parser to go into brute force search path
        String fdfContent = "%FDF-1.2\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/FDF << /F (test.fdf) >>\n" +
                ">>\n" +
                "endobj\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 1 0 R\n" +
                ">>\n" +
                "%%EOF";
        
        byte[] fdfBytes = fdfContent.getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(new ByteArrayInputStream(fdfBytes));
        
        FDFParser parser = new FDFParser(source);
        try {
            parser.parse();
        } catch (IOException e) {
            // Expected - the file is not a valid FDF, but we only care about
            // executing the call chain up to Log.debug()
        }
    }
}
