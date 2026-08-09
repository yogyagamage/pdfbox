package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.multipdf.PDFMergerUtility.AcroFormMergeMode;
import org.apache.pdfbox.multipdf.PDFMergerUtility.DocumentMergeMode;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.PageMode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDParentTreeValue;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureNode;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class PDFMergerUtilitymergeRoleMap_LogwarnFikaTest {

    @Test
    public void testAppendDocumentTriggersLogWarnInMergeRoleMap() throws IOException {
        // Create source document with structure tree root containing RoleMap
        PDDocument sourceDoc = new PDDocument();
        PDDocumentCatalog srcCatalog = sourceDoc.getDocumentCatalog();
        
        // Create source structure tree root with RoleMap
        PDStructureTreeRoot srcStructTree = new PDStructureTreeRoot();
        srcCatalog.setStructureTreeRoot(srcStructTree);
        
        // Create RoleMap dictionary in source
        COSDictionary srcRoleMap = new COSDictionary();
        srcRoleMap.setItem(COSName.getPDFName("Role1"), COSName.getPDFName("StandardRole1"));
        srcStructTree.getCOSObject().setItem(COSName.ROLE_MAP, srcRoleMap);
        
        // Create at least one page to avoid empty document issues
        PDPage srcPage = new PDPage();
        sourceDoc.addPage(srcPage);
        
        // Create destination document with structure tree root containing RoleMap with same key
        PDDocument destDoc = new PDDocument();
        PDDocumentCatalog destCatalog = destDoc.getDocumentCatalog();
        
        // Create destination structure tree root with RoleMap containing same key
        PDStructureTreeRoot destStructTree = new PDStructureTreeRoot();
        destCatalog.setStructureTreeRoot(destStructTree);
        
        // Create RoleMap dictionary in destination with same key
        COSDictionary destRoleMap = new COSDictionary();
        destRoleMap.setItem(COSName.getPDFName("Role1"), COSName.getPDFName("DifferentRole1"));
        destStructTree.getCOSObject().setItem(COSName.ROLE_MAP, destRoleMap);
        
        // Create at least one page in destination
        PDPage destPage = new PDPage();
        destDoc.addPage(destPage);
        
        // Create parent tree in destination to enable mergeStructTree path
        PDNumberTreeNode destParentTree = new PDNumberTreeNode(PDParentTreeValue.class);
        destStructTree.setParentTree(destParentTree);
        destStructTree.setParentTreeNextKey(0);
        
        // Create parent tree in source with at least one entry to trigger mergeStructTree
        PDNumberTreeNode srcParentTree = new PDNumberTreeNode(PDParentTreeValue.class);
        srcStructTree.setParentTree(srcParentTree);
        srcStructTree.setParentTreeNextKey(0);
        
        // Add an entry to source parent tree
        Map<Integer, COSObjectable> srcNumberTreeMap = new HashMap<>();
        COSDictionary parentTreeEntry = new COSDictionary();
        parentTreeEntry.setItem(COSName.TYPE, COSName.getPDFName("StructElem"));
        srcNumberTreeMap.put(0, parentTreeEntry);
        srcParentTree.setNumbers(srcNumberTreeMap);
        
        // Add an entry to destination parent tree
        Map<Integer, COSObjectable> destNumberTreeMap = new HashMap<>();
        destNumberTreeMap.put(0, parentTreeEntry);
        destParentTree.setNumbers(destNumberTreeMap);
        
        // Instantiate PDFMergerUtility using provided constructor
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        // Call entry point method - this should traverse through mergeRoleMap and trigger LOG.warn
        mergerUtility.appendDocument(destDoc, sourceDoc);
        
        // Clean up
        sourceDoc.close();
        destDoc.close();
    }
}
