package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDDocumentgetVersion_LogerrorFikaTest {

    @Test
    public void testGetVersionTriggersLogError() throws IOException {
        // Create a real PDDocument
        PDDocument document = new PDDocument();
        
        // We need to set up the internal state so that getVersion() follows the path
        // that leads to the Log.error() call. This requires:
        // 1. getDocument().getVersion() returns >= 1.4
        // 2. getDocumentCatalog().getVersion() returns a non-null string that cannot be parsed as float
        
        // Since we cannot directly modify the internal PDDocument state, we need to use
        // the available public methods to create a document with the required properties.
        // We'll create a simple PDF document and then manipulate its catalog version.
        
        // Add a page to ensure the document has a catalog
        document.addPage(new PDPage());
        
        // Get the catalog and set a non-parseable version string
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        COSDictionary catalogDict = catalog.getCOSObject();
        // The version in the catalog is stored under the "Version" key
        catalogDict.setString(COSName.VERSION, "not-a-float");
        
        // Also ensure the header version is >= 1.4
        // The header version comes from the PDF header, which is set when loading a PDF.
        // Since we created an empty document, the default version is 1.4.
        // We can verify this by checking document.getVersion() which should return 1.4
        
        // Now call the entry point method
        document.getVersion();
        
        // The method should attempt to parse "not-a-float", throw NumberFormatException,
        // and then call LOG.error("Can't extract the version number of the document catalog.", exception)
        
        // Clean up
        document.close();
    }
}
