package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class FDFDictionary_FDFAnnotationPolygonmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.SUBTYPE, COSName.getPDFName("Polygon"));
        
        FDFAnnotationPolygon annotation = new FDFAnnotationPolygon(dict);
        
        // Trigger static initialization which calls LogFactory.getLog
        Class<?> clazz = FDFAnnotationPolygon.class;
    }
}
