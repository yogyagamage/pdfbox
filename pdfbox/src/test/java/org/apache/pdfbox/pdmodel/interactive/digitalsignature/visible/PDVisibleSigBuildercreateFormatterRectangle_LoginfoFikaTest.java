package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDFTemplateStructure;

class PDVisibleSigBuildercreateFormatterRectangle_LoginfoFikaTest {

    @Test
    void testCreateFormatterRectangle() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        int[] params = {0, 0, 100, 100};
        builder.createFormatterRectangle(params);
    }
}
