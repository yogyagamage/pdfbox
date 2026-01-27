package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
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

public class PDFMergerUtilityappendDocument_LogerrorFikaTest2 {

    @Test
    public void testAppendDocumentTriggersLogError() throws IOException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();

        PDDocument destination = new PDDocument();
        PDDocument source = new PDDocument();

        try {
            PDDocumentCatalog srcCatalog = source.getDocumentCatalog();
            COSDictionary srcLabels = new COSDictionary();
            COSArray srcNums = new COSArray();
            srcLabels.setItem(COSName.NUMS, srcNums);
            srcCatalog.getCOSObject().setItem(COSName.PAGE_LABELS, srcLabels);

            srcNums.add(COSInteger.get(0));
            srcNums.add(new COSDictionary());
            srcNums.add(new COSStream()); // This is not a COSNumber, should trigger LOG.error

            PDPage page = new PDPage();
            source.addPage(page);

            mergerUtility.appendDocument(destination, source);
        } finally {
            IOUtils.closeQuietly(destination);
            IOUtils.closeQuietly(source);
        }
    }
}
