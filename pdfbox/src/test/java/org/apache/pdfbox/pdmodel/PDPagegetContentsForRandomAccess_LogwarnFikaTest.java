package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.SequenceRandomAccessRead;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PDPagegetContentsForRandomAccess_LogwarnFikaTest {

    @Test
    public void testGetContentsForRandomAccessTriggersLogWarn() throws IOException {
        // Create a COSStream that will throw IOException when createView() is called
        COSStream contentStream = Mockito.mock(COSStream.class);
        Mockito.when(contentStream.createView()).thenThrow(new IOException("Test exception"));

        // Create a COSDictionary that returns the mock stream for CONTENTS key
        COSDictionary pageDict = Mockito.mock(COSDictionary.class);
        Mockito.when(pageDict.getCOSStream(COSName.CONTENTS)).thenReturn(contentStream);
        Mockito.when(pageDict.getCOSArray(COSName.CONTENTS)).thenReturn(null);

        // Create PDPage with the mock dictionary
        PDPage page = new PDPage(pageDict);

        // This should trigger the IOException in getContentsForRandomAccess(),
        // which will then call LOG.warn("skipped malformed content stream")
        page.getContentsForRandomAccess();
    }
}
