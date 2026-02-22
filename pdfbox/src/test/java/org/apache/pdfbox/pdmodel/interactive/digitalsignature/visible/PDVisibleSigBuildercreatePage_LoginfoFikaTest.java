package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSignDesigner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDVisibleSigBuildercreatePage_LoginfoFikaTest {

    @Test
    public void testCreatePage() throws IOException {
        PDVisibleSignDesigner designer = Mockito.mock(PDVisibleSignDesigner.class);
        Mockito.when(designer.getPageWidth()).thenReturn(595.0f);
        Mockito.when(designer.getPageHeight()).thenReturn(842.0f);
        
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        builder.createPage(designer);
    }
}
