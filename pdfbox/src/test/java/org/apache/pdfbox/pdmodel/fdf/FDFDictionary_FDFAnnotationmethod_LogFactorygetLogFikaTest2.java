package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

public class FDFDictionary_FDFAnnotationmethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testGetAnnotationsTriggersFDFAnnotationStaticInitializer() throws Exception {
        // Create a COSDictionary with ANNOTS entry to trigger getAnnotations() logic
        COSDictionary fdfDictionary = new COSDictionary();
        COSArray annotsArray = new COSArray();
        
        // Add at least one COSDictionary to the array so FDFAnnotation.create() can be called
        COSDictionary annotDict = new COSDictionary();
        annotsArray.add(annotDict);
        
        fdfDictionary.setItem(COSName.ANNOTS, annotsArray);
        
        // Create FDFDictionary with the prepared dictionary
        FDFDictionary fdfDict = new FDFDictionary(fdfDictionary);
        
        // This call should trigger:
        // 1. getAnnotations() method execution
        // 2. FDFAnnotation.create() call which loads FDFAnnotation class
        // 3. FDFAnnotation static initializer (<clinit>) execution
        // 4. LogFactory.getLog(FDFAnnotation.class) invocation
        fdfDict.getAnnotations();
    }
}
