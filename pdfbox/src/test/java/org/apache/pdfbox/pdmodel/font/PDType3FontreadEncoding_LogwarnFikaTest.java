package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

class PDType3FontreadEncoding_LogwarnFikaTest {

    @Test
    void testReadEncodingTriggersLogWarn() throws Exception {
        COSDictionary fontDictionary = new COSDictionary();
        fontDictionary.setItem(COSName.ENCODING, COSName.getPDFName("UnknownEncoding"));
        
        ResourceCache resourceCache = null;
        
        PDType3Font font = new PDType3Font(fontDictionary, resourceCache);
    }
}
