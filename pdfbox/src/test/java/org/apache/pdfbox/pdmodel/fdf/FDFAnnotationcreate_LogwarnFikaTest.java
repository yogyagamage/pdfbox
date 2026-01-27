package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotationcreate_LogwarnFikaTest {

    @Test
    void testCreateTriggersLogWarn() {
        // Create a COSDictionary with an unknown subtype to trigger the log warning
        COSDictionary fdfDic = new COSDictionary();
        // Set a subtype that doesn't match any known annotation type
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("UnknownAnnotationType"));
        
        // Call the static entry point method
        FDFAnnotation.create(fdfDic);
        
        // No assertions - test passes if no exception is thrown
    }
}
