package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class PDVisibleSigBuildercreateFormatterRectangle_LoginfoFikaTest {

    @Test
    public void testCreateFormatterRectangle() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        // Create a real PDFStructure to ensure the method executes fully
        // We'll use reflection to set the required field since it's likely private
        try {
            // Set up the LOG field if needed (though it should already be initialized)
            // Just ensure the method can execute without NPE
            java.lang.reflect.Field pdfStructureField = PDVisibleSigBuilder.class
                    .getDeclaredField("pdfStructure");
            pdfStructureField.setAccessible(true);
            
            // Create a minimal mock that won't interfere with the Log.info call
            Object pdfStructureMock = mock(Class.forName(
                    "org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDFTemplateStructure"));
            pdfStructureField.set(builder, pdfStructureMock);
            
            // Also ensure LOG is initialized (it's a static final field)
            // The actual LOG.info() call should work with default configuration
            
        } catch (Exception e) {
            // If reflection fails, we'll still call the method - it might work with default state
            // or throw an exception, but we're only concerned with reaching the Log.info call
        }
        
        // Call the method with valid parameters
        int[] params = {10, 20, 30, 40};
        builder.createFormatterRectangle(params);
    }
}
