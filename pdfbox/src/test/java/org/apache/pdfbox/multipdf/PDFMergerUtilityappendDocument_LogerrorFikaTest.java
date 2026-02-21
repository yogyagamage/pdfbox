package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PDFMergerUtilityappendDocument_LogerrorFikaTest {

    @Test
    public void testAppendDocumentTriggersLogError(@TempDir Path tempDir) throws IOException {
        PDDocument destination = new PDDocument();
        PDDocument source = new PDDocument();
        
        try {
            PDFMergerUtility mergerUtility = new PDFMergerUtility();
            
            // Create a source document with page labels that will trigger the error
            PDDocumentCatalog srcCatalog = source.getDocumentCatalog();
            
            // Create a COSDictionary for page labels with invalid structure
            org.apache.pdfbox.cos.COSDictionary srcLabels = new org.apache.pdfbox.cos.COSDictionary();
            org.apache.pdfbox.cos.COSArray srcNums = new org.apache.pdfbox.cos.COSArray();
            
            // Add a non-number at index 0 to trigger the error
            srcNums.add(org.apache.pdfbox.cos.COSNull.NULL); // This is not a COSNumber
            srcNums.add(new org.apache.pdfbox.cos.COSString("Label1"));
            
            srcLabels.setItem(org.apache.pdfbox.cos.COSName.NUMS, srcNums);
            srcCatalog.getCOSObject().setItem(org.apache.pdfbox.cos.COSName.PAGE_LABELS, srcLabels);
            
            // Add a page to source to ensure page labels processing happens
            PDPage page = new PDPage();
            source.addPage(page);
            
            // Add a page to destination to ensure destNums exists
            destination.addPage(new PDPage());
            
            // Create destination catalog with page labels dictionary
            PDDocumentCatalog destCatalog = destination.getDocumentCatalog();
            org.apache.pdfbox.cos.COSDictionary destLabels = new org.apache.pdfbox.cos.COSDictionary();
            org.apache.pdfbox.cos.COSArray destNums = new org.apache.pdfbox.cos.COSArray();
            destLabels.setItem(org.apache.pdfbox.cos.COSName.NUMS, destNums);
            destCatalog.getCOSObject().setItem(org.apache.pdfbox.cos.COSName.PAGE_LABELS, destLabels);
            
            // Ensure source document has a structure tree root to avoid NPE
            PDStructureTreeRoot srcStructTree = new PDStructureTreeRoot();
            srcCatalog.setStructureTreeRoot(srcStructTree);
            
            // Ensure destination has a structure tree root
            PDStructureTreeRoot destStructTree = new PDStructureTreeRoot();
            destCatalog.setStructureTreeRoot(destStructTree);
            
            // Ensure parent tree exists
            org.apache.pdfbox.pdmodel.common.PDNumberTreeNode parentTree = 
                new org.apache.pdfbox.pdmodel.common.PDNumberTreeNode(
                    org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDParentTreeValue.class);
            destStructTree.setParentTree(parentTree);
            
            // Create a map for the parent tree
            Map<Integer, COSObjectable> numberTreeMap = new HashMap<>();
            parentTree.setNumbers(numberTreeMap);
            
            // Call the method - this should trigger LOG.error when processing page labels
            mergerUtility.appendDocument(destination, source);
            
        } finally {
            // Clean up
            try {
                source.close();
            } catch (IOException e) {
                // Ignore
            }
            try {
                destination.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}
