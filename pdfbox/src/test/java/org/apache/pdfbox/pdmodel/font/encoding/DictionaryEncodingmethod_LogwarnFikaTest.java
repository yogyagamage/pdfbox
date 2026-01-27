package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

public class DictionaryEncodingmethod_LogwarnFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // Create a COSDictionary with BASE_ENCODING key to trigger the warn log
        COSDictionary fontEncoding = new COSDictionary();
        fontEncoding.setItem(COSName.BASE_ENCODING, COSName.STANDARD_ENCODING);
        
        // Instantiate using the entry point constructor
        DictionaryEncoding dictionaryEncoding = new DictionaryEncoding(fontEncoding);
    }
}
