package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.IOException;

public class PDVisibleSigBuildercreateBackgroundLayerForm_LoginfoFikaTest {

    @Test
    public void testCreateBackgroundLayerForm() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        builder.createTemplate(page);
        
        PDResources innerFormResource = new PDResources();
        PDRectangle bbox = new PDRectangle(100, 100);
        
        builder.createBackgroundLayerForm(innerFormResource, bbox);
        
        document.close();
    }
}
