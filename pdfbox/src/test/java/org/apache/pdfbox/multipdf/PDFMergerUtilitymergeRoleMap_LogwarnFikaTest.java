package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.PDFCloneUtility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDFMergerUtilitymergeRoleMap_LogwarnFikaTest {

    @Test
    public void testMergeRoleMapTriggersLogWarn() throws IOException {
        // Create source and destination documents
        PDDocument sourceDoc = new PDDocument();
        PDDocument destDoc = new PDDocument();
        
        // Create structure tree roots with role maps that will cause conflict
        PDStructureTreeRoot srcStructTree = new PDStructureTreeRoot();
        PDStructureTreeRoot destStructTree = new PDStructureTreeRoot();
        
        // Create source role map dictionary
        COSDictionary srcRoleMap = new COSDictionary();
        srcRoleMap.setItem(COSName.P, COSName.getPDFName("Span")); // Use getPDFName instead of SPAN
        srcRoleMap.setItem(COSName.L, COSName.getPDFName("Lbl"));  // Another entry
        
        // Create destination role map dictionary with same key but different value
        COSDictionary destRoleMap = new COSDictionary();
        destRoleMap.setItem(COSName.P, COSName.getPDFName("Paragraph")); // Different value for same key
        
        // Set the role maps
        srcStructTree.getCOSObject().setItem(COSName.ROLE_MAP, srcRoleMap);
        destStructTree.getCOSObject().setItem(COSName.ROLE_MAP, destRoleMap);
        
        // Set structure tree roots in document catalogs
        PDDocumentCatalog srcCatalog = sourceDoc.getDocumentCatalog();
        PDDocumentCatalog destCatalog = destDoc.getDocumentCatalog();
        
        // Use reflection to set private field if needed, but we can use public methods
        // First ensure destination has a structure tree
        destCatalog.setStructureTreeRoot(destStructTree);
        
        // For source, we need to ensure it has a structure tree with parent tree
        // to trigger mergeStructTree = true in appendDocument
        srcCatalog.setStructureTreeRoot(srcStructTree);
        
        // Create a parent tree for source structure tree
        Map<Integer, COSObjectable> srcNumberTreeMap = new HashMap<>();
        srcNumberTreeMap.put(0, new COSDictionary());
        org.apache.pdfbox.pdmodel.common.PDNumberTreeNode srcParentTree = 
            new org.apache.pdfbox.pdmodel.common.PDNumberTreeNode(
                org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDParentTreeValue.class);
        srcParentTree.setNumbers(srcNumberTreeMap);
        srcStructTree.setParentTree(srcParentTree);
        srcStructTree.setParentTreeNextKey(1);
        
        // Create a parent tree for destination structure tree
        Map<Integer, COSObjectable> destNumberTreeMap = new HashMap<>();
        destNumberTreeMap.put(0, new COSDictionary());
        org.apache.pdfbox.pdmodel.common.PDNumberTreeNode destParentTree = 
            new org.apache.pdfbox.pdmodel.common.PDNumberTreeNode(
                org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDParentTreeValue.class);
        destParentTree.setNumbers(destNumberTreeMap);
        destStructTree.setParentTree(destParentTree);
        destStructTree.setParentTreeNextKey(1);
        
        // Add a page to source document to ensure pages exist
        sourceDoc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        
        // Create PDFMergerUtility instance using provided constructor
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        // Call the entry point method - this should trigger mergeRoleMap which will call LOG.warn
        mergerUtility.appendDocument(destDoc, sourceDoc);
        
        // Clean up
        sourceDoc.close();
        destDoc.close();
    }
}
