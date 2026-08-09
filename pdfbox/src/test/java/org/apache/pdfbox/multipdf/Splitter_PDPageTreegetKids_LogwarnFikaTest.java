package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Splitter_PDPageTreegetKids_LogwarnFikaTest {

    @Test
    void testSplitTriggersLogWarn() throws IOException {
        // Create a source document with a malformed page tree that will cause
        // PDPageTree.getKids() to encounter a null kid, triggering LOG.warn()
        PDDocument sourceDocument = new PDDocument();
        
        // Create a page tree root dictionary
        COSDictionary pageTreeRoot = new COSDictionary();
        pageTreeRoot.setItem(COSName.TYPE, COSName.PAGES);
        pageTreeRoot.setInt(COSName.COUNT, 1);
        
        // Create a kids array with a null entry to trigger the warning
        COSArray kids = new COSArray();
        kids.add(null); // This null will cause LOG.warn("replaced null entry with an empty page")
        pageTreeRoot.setItem(COSName.KIDS, kids);
        
        // Set the page tree root in the document catalog
        sourceDocument.getDocumentCatalog().getCOSObject().setItem(COSName.PAGES, pageTreeRoot);
        
        // Create a page dictionary (though it won't be properly linked due to null kid)
        COSDictionary pageDict = new COSDictionary();
        pageDict.setItem(COSName.TYPE, COSName.PAGE);
        pageDict.setItem(COSName.PARENT, pageTreeRoot);
        
        // Add the page to the document's page tree (bypassing normal addition to ensure malformed structure)
        sourceDocument.getPages().getCOSObject().setItem(COSName.KIDS, kids);
        
        // Create Splitter instance using the default constructor
        Splitter splitter = new Splitter();
        
        // Set splitter to process at least one page
        splitter.setStartPage(1);
        splitter.setEndPage(1);
        splitter.setSplitAtPage(1);
        
        // Execute the entry point method - this should traverse through the call chain
        // and eventually reach PDPageTree.getKids() where the null kid triggers LOG.warn()
        splitter.split(sourceDocument);
        
        // Close the document
        sourceDocument.close();
    }
}
