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
            PDStream stream = new PDStream(document);
            
            // Create a filter that doesn't match any known filter in getSuffix()
            // This will trigger the else branch where LOG.warn is called
            stream.getCOSObject().setItem(COSName.FILTER, 
                new org.apache.pdfbox.cos.COSArray(
                    Arrays.asList(COSName.getPDFName("UnknownFilter"))
                )
            );
            
            PDImageXObject imageXObject = new PDImageXObject(stream, resources);
            imageXObject.getSuffix();
        }
    }
}
