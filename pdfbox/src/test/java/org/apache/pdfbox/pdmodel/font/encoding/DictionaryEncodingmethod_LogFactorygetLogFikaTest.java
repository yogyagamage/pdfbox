package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

public class DictionaryEncodingmethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPoint() {
        COSDictionary fontEncoding = new COSDictionary();
        fontEncoding.setItem(COSName.BASE_ENCODING, COSName.STANDARD_ENCODING);
        
        DictionaryEncoding dictionaryEncoding = new DictionaryEncoding(fontEncoding);
    }
}
