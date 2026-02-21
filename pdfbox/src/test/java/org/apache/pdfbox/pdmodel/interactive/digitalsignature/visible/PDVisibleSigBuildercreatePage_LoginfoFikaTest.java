package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSignDesigner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVisibleSigBuildercreatePage_LoginfoFikaTest {

    @Test
    void testCreatePage() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDVisibleSignDesigner designer = Mockito.mock(PDVisibleSignDesigner.class);
        Mockito.when(designer.getPageWidth()).thenReturn(595.0f);
        Mockito.when(designer.getPageHeight()).thenReturn(842.0f);
        
        builder.createPage(designer);
    }
}
