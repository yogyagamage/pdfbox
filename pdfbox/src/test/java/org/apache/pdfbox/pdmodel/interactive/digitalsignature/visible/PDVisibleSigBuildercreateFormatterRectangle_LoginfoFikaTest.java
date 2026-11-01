package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDFTemplateStructure;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import static org.mockito.Mockito.mock;

public class PDVisibleSigBuildercreateFormatterRectangle_LoginfoFikaTest {

    @Test
    public void testCreateFormatterRectangle() {
        PDFTemplateStructure pdfStructure = mock(PDFTemplateStructure.class);
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        try {
            java.lang.reflect.Field field = PDVisibleSigBuilder.class.getDeclaredField("pdfStructure");
            field.setAccessible(true);
            field.set(builder, pdfStructure);
            
            java.lang.reflect.Field logField = PDVisibleSigBuilder.class.getDeclaredField("LOG");
            logField.setAccessible(true);
            org.apache.commons.logging.Log log = (org.apache.commons.logging.Log) logField.get(builder);
            
            if (log == null) {
                log = org.apache.commons.logging.LogFactory.getLog(PDVisibleSigBuilder.class);
                logField.set(builder, log);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        int[] params = {10, 20, 30, 40};
        builder.createFormatterRectangle(params);
    }
}
