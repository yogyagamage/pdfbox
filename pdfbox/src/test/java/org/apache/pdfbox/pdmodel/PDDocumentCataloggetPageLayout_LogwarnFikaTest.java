package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageLayout;
import org.junit.jupiter.api.Test;

public class PDDocumentCataloggetPageLayout_LogwarnFikaTest {

    @Test
    public void testGetPageLayoutTriggersLogWarn() throws Exception {
        COSDictionary rootDict = new COSDictionary();
        rootDict.setName(COSName.PAGE_LAYOUT, "INVALID_LAYOUT");
        
        PDDocumentCatalog catalog = new PDDocumentCatalog(null, rootDict);
        catalog.getPageLayout();
    }
}
