package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFCatalog_FDFDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    void testGetFDFTriggersLogFactoryGetLog() {
        COSDictionary mockCosDictionary = Mockito.mock(COSDictionary.class);
        FDFCatalog fdfCatalog = new FDFCatalog(mockCosDictionary);
        
        fdfCatalog.getFDF();
    }
}
