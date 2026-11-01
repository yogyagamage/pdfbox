package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageLayout;
import org.junit.jupiter.api.Test;

public class PDDocumentCataloggetPageLayout_LogwarnFikaTest {

    @Test
    public void testGetPageLayoutInvokesLogWarn() throws Exception {
        // Create a real COSDictionary as the root
        COSDictionary root = new COSDictionary();
        // Set an invalid PageLayout value that will cause IllegalArgumentException
        root.setString(COSName.PAGE_LAYOUT, "INVALID_LAYOUT");
        
        // Create the catalog with our root dictionary
        PDDocumentCatalog catalog = new PDDocumentCatalog(null, root);
        
        // This should trigger the IllegalArgumentException and invoke Log.warn
        catalog.getPageLayout();
    }
}
