package org.apache.pdfbox.cos;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class COSDocument_COSStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testCreateCOSStreamTriggersStaticInitializer() throws IOException {
        // Create a mock parser that returns a mock RandomAccessReadView
        ICOSParser mockParser = Mockito.mock(ICOSParser.class);
        RandomAccessReadView mockView = Mockito.mock(RandomAccessReadView.class);
        Mockito.when(mockParser.createRandomAccessReadView(Mockito.anyLong(), Mockito.anyLong()))
               .thenReturn(mockView);
        
        // Create COSDocument with mock parser
        COSDocument document = new COSDocument(mockParser);
        
        // Create a COSDictionary for the stream
        COSDictionary dictionary = new COSDictionary();
        
        // Call the entry point method - this will trigger COSStream static initializer
        // which calls LogFactory.getLog(COSStream.class)
        document.createCOSStream(dictionary, 0L, 100L);
    }
}
