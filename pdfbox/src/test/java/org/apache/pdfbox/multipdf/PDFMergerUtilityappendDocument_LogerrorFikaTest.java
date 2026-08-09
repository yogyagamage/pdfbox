package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PDFMergerUtilityappendDocument_LogerrorFikaTest {

    @Test
    public void testAppendDocumentTriggersLogError() throws IOException {
        // Create source document with page labels that will trigger LOG.error
        PDDocument source = createSourceDocumentWithInvalidPageLabels();
        PDDocument destination = createDestinationDocument();
        
        PDFMergerUtility merger = new PDFMergerUtility();
        merger.appendDocument(destination, source);
        
        // Clean up
        source.close();
        destination.close();
    }

    private PDDocument createSourceDocumentWithInvalidPageLabels() throws IOException {
        PDDocument doc = new PDDocument();
        
        // Create a page
        PDPage page = new PDPage();
        doc.addPage(page);
        
        // Get catalog
        PDDocumentCatalog catalog = doc.getDocumentCatalog();
        COSDictionary catalogDict = catalog.getCOSObject();
        
        // Create page labels dictionary with invalid entry (non-number at index 0)
        COSDictionary pageLabels = new COSDictionary();
        COSArray nums = new COSArray();
        
        // Add invalid entry: first element should be COSNumber but we use COSName instead
        nums.add(COSName.A); // This is NOT a COSNumber, will trigger LOG.error
        nums.add(new COSDictionary()); // Second element can be anything
        
        pageLabels.setItem(COSName.NUMS, nums);
        catalogDict.setItem(COSName.PAGE_LABELS, pageLabels);
        
        return doc;
    }

    private PDDocument createDestinationDocument() throws IOException {
        PDDocument doc = new PDDocument();
        
        // Add at least one page to destination
        PDPage page = new PDPage();
        doc.addPage(page);
        
        return doc;
    }
}
