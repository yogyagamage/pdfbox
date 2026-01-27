package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

public class PDThreadBead_PDPagemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetPageTriggersStaticInitializer() {
        // Create a COSDictionary with a P entry that points to a valid page dictionary
        COSDictionary pageDict = new COSDictionary();
        pageDict.setItem(COSName.TYPE, COSName.PAGE);
        
        COSDictionary beadDict = new COSDictionary();
        beadDict.setItem(COSName.P, pageDict);
        
        // Create PDThreadBead using constructor with COSDictionary parameter
        PDThreadBead bead = new PDThreadBead(beadDict);
        
        // Call getPage() which will trigger PDPage class static initializer
        // The static initializer contains: private static final Log LOG = LogFactory.getLog(PDPage.class);
        bead.getPage();
    }
}
