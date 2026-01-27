package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class PDImageXObjectgetSuffix_LogwarnFikaTest {

    @Test
    public void testGetSuffixTriggersLogWarn() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDResources resources = new PDResources();
            
            // Create a PDStream with a filter that doesn't match any known filter
            // This will cause getSuffix() to reach the else block and call LOG.warn()
            PDStream stream = new PDStream(document);
            stream.getCOSObject().setItem(COSName.FILTER, 
                new org.apache.pdfbox.cos.COSArray(
                    Arrays.asList(COSName.getPDFName("UnknownFilter"))
                )
            );
            
            PDImageXObject imageXObject = new PDImageXObject(stream, resources);
            
            // This call should trigger the else block in getSuffix() 
            // which calls LOG.warn("getSuffix() returns null, filters: " + filters)
            imageXObject.getSuffix();
        }
    }
}
