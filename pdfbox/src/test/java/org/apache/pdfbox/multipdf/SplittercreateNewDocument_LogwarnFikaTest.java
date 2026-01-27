package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class SplittercreateNewDocument_LogwarnFikaTest {

    @Test
    public void testSplitTriggersLogWarn() throws IOException {
        // Create a source document with a document information dictionary containing nested entries
        PDDocument sourceDocument = new PDDocument();
        
        // Create a document information dictionary with a nested dictionary entry
        PDDocumentInformation docInfo = new PDDocumentInformation();
        COSDictionary infoDict = docInfo.getCOSObject();
        
        // Add a nested dictionary entry that will trigger the warning
        COSDictionary nestedDict = new COSDictionary();
        infoDict.setItem(COSName.getPDFName("CustomKey"), nestedDict);
        
        // Set the document information
        sourceDocument.setDocumentInformation(docInfo);
        
        // Create a page to ensure the splitter has something to process
        sourceDocument.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        
        // Create Splitter instance
        Splitter splitter = new Splitter();
        
        // Set split length to ensure createNewDocument is called
        splitter.setSplitAtPage(1);
        
        // Execute the entry point method
        List<PDDocument> result = splitter.split(sourceDocument);
        
        // Clean up
        for (PDDocument doc : result) {
            doc.close();
        }
        sourceDocument.close();
    }
}
