package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PageMode;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDParentTreeValue;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationText;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;

public class PDFMergerUtilityappendDocument_LogerrorFikaTest {

    @Test
    public void testAppendDocumentTriggersLogError(@TempDir Path tempDir) throws IOException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        PDDocument destination = new PDDocument();
        PDDocument source = new PDDocument();
        
        PDPage destPage = new PDPage(PDRectangle.A4);
        destination.addPage(destPage);
        
        PDPage srcPage = new PDPage(PDRectangle.A4);
        source.addPage(srcPage);
        
        PDDocumentCatalog srcCatalog = source.getDocumentCatalog();
        COSDictionary srcLabels = new COSDictionary();
        COSArray srcNums = new COSArray();
        
        srcNums.add(new COSString("not a number"));
        srcNums.add(new COSDictionary());
        
        srcLabels.setItem(COSName.NUMS, srcNums);
        srcCatalog.getCOSObject().setItem(COSName.PAGE_LABELS, srcLabels);
        
        mergerUtility.appendDocument(destination, source);
        
        source.close();
        destination.close();
    }
}
