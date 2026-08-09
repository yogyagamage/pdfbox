package org.apache.pdfbox.pdmodel;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PDDocument_COSObjectmethod_LogFactorygetLogFikaTest {

    @Test
    public void testSaveIncrementalTriggersLogFactoryGetLog() throws IOException {
        // Create a COSDocument with minimal structure to allow incremental save
        COSDocument cosDoc = new COSDocument();
        COSDictionary trailer = new COSDictionary();
        cosDoc.setTrailer(trailer);
        
        // Create root dictionary
        COSDictionary rootDict = new COSDictionary();
        rootDict.setItem(COSName.TYPE, COSName.CATALOG);
        rootDict.setItem(COSName.VERSION, COSName.getPDFName("1.4"));
        trailer.setItem(COSName.ROOT, rootDict);
        
        // Create pages structure
        COSDictionary pagesDict = new COSDictionary();
        pagesDict.setItem(COSName.TYPE, COSName.PAGES);
        pagesDict.setItem(COSName.COUNT, COSInteger.ZERO);
        COSArray kidsArray = new COSArray();
        pagesDict.setItem(COSName.KIDS, kidsArray);
        rootDict.setItem(COSName.PAGES, pagesDict);
        
        // Create a COSObject that will trigger static initialization
        COSObject cosObject = new COSObject(null);
        
        // Add the COSObject to the document structure so it gets written
        // We'll add it as an indirect object in the trailer
        COSDictionary infoDict = new COSDictionary();
        infoDict.setItem(COSName.CREATOR, COSName.getPDFName("Test"));
        trailer.setItem(COSName.INFO, infoDict);
        
        // Create PDDocument using constructor that accepts COSDocument and source
        // We need a non-null pdfSource to allow incremental save
        byte[] pdfData = "%PDF-1.4\n".getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(pdfData);
        PDDocument document = new PDDocument(cosDoc, source);
        
        // Prepare objectsToWrite set - include the info dictionary which contains our COSObject
        Set<COSDictionary> objectsToWrite = new HashSet<>();
        objectsToWrite.add(infoDict);
        
        // Create output stream
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        // Call the entry point method - this should trigger the full chain ending with LogFactory.getLog
        document.saveIncremental(output, objectsToWrite);
        
        // Cleanup
        document.close();
        output.close();
    }
}
