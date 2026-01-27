package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageTreegetKids_LogwarnFikaTest {

    @Test
    void test() throws Exception {
        // Create a root dictionary with a KIDS array containing a null entry
        COSDictionary root = new COSDictionary();
        COSArray kids = new COSArray();
        kids.add(null); // This will trigger the LOG.warn in getKids()
        root.setItem(COSName.KIDS, kids);
        root.setItem(COSName.TYPE, COSName.PAGES);
        
        // Create PDPageTree with the prepared root
        PDPageTree pageTree = new PDPageTree(root);
        
        // Create a PDPage to search for
        PDPage page = new PDPage();
        
        // Call indexOf which should traverse through findPage -> getKids -> LOG.warn
        pageTree.indexOf(page);
    }
}
