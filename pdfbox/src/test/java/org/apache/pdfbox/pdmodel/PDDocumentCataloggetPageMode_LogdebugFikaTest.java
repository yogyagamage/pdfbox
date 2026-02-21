package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageMode;
import org.junit.jupiter.api.Test;

public class PDDocumentCataloggetPageMode_LogdebugFikaTest {

    @Test
    public void testGetPageModeInvokesLogDebug() {
        COSDictionary rootDict = new COSDictionary();
        rootDict.setName(COSName.PAGE_MODE, "InvalidModeValue");
        
        PDDocumentCatalog catalog = new PDDocumentCatalog(null, rootDict);
        catalog.getPageMode();
    }
}
