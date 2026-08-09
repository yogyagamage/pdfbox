package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class SplittercreateNewDocument_LogwarnFikaTest {

    @Test
    public void testSplitTriggersLogWarn() throws IOException {
        // Create a source document with document information containing nested dictionary
        PDDocument sourceDocument = new PDDocument();
        PDDocumentInformation docInfo = new PDDocumentInformation();
        COSDictionary infoDict = docInfo.getCOSObject();
        
        // Add a nested dictionary entry to trigger the warning in createNewDocument()
        COSDictionary nestedDict = new COSDictionary();
        infoDict.setItem(org.apache.pdfbox.cos.COSName.getPDFName("CustomKey"), nestedDict);
        
        // Set the document information (this creates a scenario where /Root and /Info may share dict)
        sourceDocument.setDocumentInformation(docInfo);
        
        // Add at least one page to process
        sourceDocument.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        
        // Create Splitter instance using default constructor
        Splitter splitter = new Splitter();
        
        // Set split length to 1 to ensure createNewDocument is called for each page
        splitter.setSplitAtPage(1);
        
        // Execute the entry point method
        List<PDDocument> result = splitter.split(sourceDocument);
        
        // Close all documents to avoid resource leaks
        for (PDDocument doc : result) {
            doc.close();
        }
        sourceDocument.close();
    }
}
