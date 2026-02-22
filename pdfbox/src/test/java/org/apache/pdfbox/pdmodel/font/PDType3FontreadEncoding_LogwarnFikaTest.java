package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDType3FontreadEncoding_LogwarnFikaTest {

    @Test
    void test() throws IOException {
        COSDictionary fontDictionary = new COSDictionary();
        fontDictionary.setItem(COSName.ENCODING, COSName.getPDFName("UnknownEncoding"));
        
        ResourceCache resourceCache = Mockito.mock(ResourceCache.class);
        
        PDType3Font font = new PDType3Font(fontDictionary, resourceCache);
    }
}
