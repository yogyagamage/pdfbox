package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DictionaryEncodingmethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPoint() {
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockDict.getCOSName(COSName.BASE_ENCODING)).thenReturn(null);
        
        new DictionaryEncoding(mockDict);
    }
}
