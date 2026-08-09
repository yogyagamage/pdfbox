package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FDFDictionary_FDFAnnotationcreate_LogwarnFikaTest {

    @Test
    void testGetAnnotationsTriggersLogWarn() throws IOException {
        // Create a COSDictionary that will be used as the internal fdf field
        COSDictionary fdfDictionary = new COSDictionary();
        
        // Create a COSArray for annotations with one entry that will trigger the warning
        COSArray annotsArray = new COSArray();
        
        // Create a COSDictionary for the annotation with an unknown subtype
        COSDictionary unknownAnnotationDict = new COSDictionary();
        // Set a subtype that doesn't match any known annotation type
        unknownAnnotationDict.setItem(COSName.SUBTYPE, COSName.getPDFName("UnknownType"));
        
        // Add the unknown annotation dictionary to the array
        annotsArray.add(unknownAnnotationDict);
        
        // Set the ANNOTS entry in the main dictionary
        fdfDictionary.setItem(COSName.ANNOTS, annotsArray);
        
        // Create FDFDictionary using the constructor that takes COSDictionary
        FDFDictionary fdfDict = new FDFDictionary(fdfDictionary);
        
        // Call the entry point method - this should traverse through
        // FDFAnnotation.create() and trigger Log.warn()
        fdfDict.getAnnotations();
    }
}
