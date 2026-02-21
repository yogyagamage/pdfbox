package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class DictionaryEncodingmethod_LogwarnFikaTest {

    @Test
    void testLogWarnInvocation() {
        COSDictionary fontEncoding = new COSDictionary();
        fontEncoding.setItem(COSName.BASE_ENCODING, COSName.WIN_ANSI_ENCODING);
        
        new DictionaryEncoding(fontEncoding);
    }
}
