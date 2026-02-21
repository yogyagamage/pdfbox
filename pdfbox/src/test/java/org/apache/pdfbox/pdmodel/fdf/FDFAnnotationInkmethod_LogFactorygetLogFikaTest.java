package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSFloat;
import java.util.ArrayList;
import java.util.List;

public class FDFAnnotationInkmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Create a minimal COSDictionary to satisfy constructor requirements
        COSDictionary dict = new COSDictionary();
        dict.setItem("Subtype", org.apache.pdfbox.cos.COSName.getPDFName("Ink"));
        
        // Create ink list with at least one stroke containing at least one point
        List<float[]> inkList = new ArrayList<>();
        float[] stroke = new float[]{10.0f, 20.0f, 30.0f, 40.0f};
        inkList.add(stroke);
        
        // Create COSArray for inklist
        COSArray inkListArray = new COSArray();
        for (float[] strokePoints : inkList) {
            COSArray strokeArray = new COSArray();
            for (float point : strokePoints) {
                strokeArray.add(new COSFloat(point));
            }
            inkListArray.add(strokeArray);
        }
        dict.setItem("InkList", inkListArray);
        
        // Instantiate FDFAnnotationInk - this triggers static initialization
        // which calls LogFactory.getLog(FDFAnnotationInk.class)
        FDFAnnotationInk annotation = new FDFAnnotationInk(dict);
        
        // Additional call to ensure static field is accessed
        // This may trigger class initialization if not already done
        Class<?> clazz = FDFAnnotationInk.class;
    }
}
