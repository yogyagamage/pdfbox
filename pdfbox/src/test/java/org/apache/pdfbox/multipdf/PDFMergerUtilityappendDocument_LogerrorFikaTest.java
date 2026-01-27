package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFMergerUtilityappendDocument_LogerrorFikaTest {

    @Test
    public void testAppendDocumentTriggersLogError() throws IOException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();

        PDDocument destination = new PDDocument();
        PDDocument source = new PDDocument();

        try {
            // Create a source document with page labels that will trigger the LOG.error call
            // We need a COSArray for srcNums where the first element is not a COSNumber
            PDDocumentCatalog srcCatalog = source.getDocumentCatalog();
            COSDictionary srcLabels = new COSDictionary();
            COSArray srcNums = new COSArray();
            
            // Add a non-COSNumber element at index 0 to trigger the error
            srcNums.add(COSName.getPDFName("NotANumber")); // This is not a COSNumber
            srcNums.add(new COSDictionary()); // Dummy second element
            
            srcLabels.setItem(COSName.NUMS, srcNums);
            srcCatalog.getCOSObject().setItem(COSName.PAGE_LABELS, srcLabels);

            // Ensure destination has no page labels initially
            PDDocumentCatalog destCatalog = destination.getDocumentCatalog();
            destCatalog.getCOSObject().removeItem(COSName.PAGE_LABELS);

            // Add at least one page to source so iteration happens
            PDPage srcPage = new PDPage();
            source.addPage(srcPage);

            // Call the entry point method
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
