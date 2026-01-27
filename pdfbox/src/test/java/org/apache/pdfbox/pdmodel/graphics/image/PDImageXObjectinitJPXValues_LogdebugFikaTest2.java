package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class PDImageXObjectinitJPXValues_LogdebugFikaTest2 {

    @Test
    void testGetWidthTriggersLogDebug() throws IOException {
        PDDocument document = new PDDocument();
        
        // Create a COSArray with JPX filter to trigger hasJPXFilter = true
        COSArray filters = new COSArray();
        filters.add(COSName.JPX_DECODE);
        
        // Create a PDStream that will throw IOException when createInputStream() is called
        // This will trigger the catch block in initJPXValues()
        PDStream stream = new PDStream(document);
        stream.getCOSObject().setItem(COSName.FILTER, filters);
        
        // Create PDImageXObject with the stream that has JPX filter
        PDImageXObject imageXObject = new PDImageXObject(stream, new PDResources());
        
        // Call getWidth() which should call initJPXValues()
        // Since hasJPXFilter = true and jpxValuesInitialized = false,
        // it will try to createInputStream() which will throw IOException
        // triggering LOG.debug() call
        imageXObject.getWidth();
        
        document.close();
    }
}
