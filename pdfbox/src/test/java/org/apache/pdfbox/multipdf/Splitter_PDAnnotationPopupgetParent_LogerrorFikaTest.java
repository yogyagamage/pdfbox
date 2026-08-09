package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Splitter_PDAnnotationPopupgetParent_LogerrorFikaTest {

    @Test
    public void testSplitTriggersLogError() throws IOException {
        // Create a source document with at least one page
        PDDocument sourceDocument = new PDDocument();
        PDPage page = new PDPage();
        sourceDocument.addPage(page);

        // Create a popup annotation with a non-markup parent annotation
        COSDictionary popupDict = new COSDictionary();
        popupDict.setItem(COSName.TYPE, COSName.ANNOT);
        popupDict.setItem(COSName.SUBTYPE, COSName.POPUP);
        
        // Create a non-markup annotation dictionary (e.g., a link annotation)
        COSDictionary nonMarkupDict = new COSDictionary();
        nonMarkupDict.setItem(COSName.TYPE, COSName.ANNOT);
        nonMarkupDict.setItem(COSName.SUBTYPE, COSName.LINK);
        
        // Set the parent reference to the non-markup annotation
        popupDict.setItem(COSName.PARENT, nonMarkupDict);
        
        // Create the popup annotation
        PDAnnotationPopup popup = (PDAnnotationPopup) PDAnnotation.createAnnotation(popupDict);
        
        // Add the popup annotation to the page
        List<PDAnnotation> annotations = new ArrayList<>();
        annotations.add(popup);
        page.setAnnotations(annotations);

        // Instantiate Splitter using the default constructor
        Splitter splitter = new Splitter();
        
        // Set split length to 1 to ensure each page becomes a separate document
        splitter.setSplitAtPage(1);
        
        // Set start and end pages to include the page with the annotation
        splitter.setStartPage(1);
        splitter.setEndPage(1);

        // Execute the entry point method
        splitter.split(sourceDocument);

        // Close the source document
        sourceDocument.close();
    }
}
