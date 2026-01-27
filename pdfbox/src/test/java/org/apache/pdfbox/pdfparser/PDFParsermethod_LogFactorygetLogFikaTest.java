package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.io.RandomAccessRead;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testParseTriggersStaticInitializer() throws IOException {
        // Create a mock RandomAccessRead to satisfy constructor requirements
        RandomAccessRead mockSource = Mockito.mock(RandomAccessRead.class);
        
        // Configure the mock to return minimal data for header parsing
        Mockito.when(mockSource.read()).thenReturn((int) '%', (int) 'P', (int) 'D', (int) 'F', (int) '-', 
            (int) '1', (int) '.', (int) '4', (int) '\n', -1);
        Mockito.when(mockSource.isEOF()).thenReturn(false, false, false, false, false, false, false, false, false, true);
        
        // Create PDFParser instance using the simplest constructor
        PDFParser parser = new PDFParser(mockSource);
        
        // Call the entry point method - this will trigger static initialization
        // which calls LogFactory.getLog(PDFParser.class)
        try {
            parser.parse(true);
        } catch (IOException e) {
            // Expected since we're providing minimal mock data
            // The static initialization already happened before the exception
        }
    }
}
