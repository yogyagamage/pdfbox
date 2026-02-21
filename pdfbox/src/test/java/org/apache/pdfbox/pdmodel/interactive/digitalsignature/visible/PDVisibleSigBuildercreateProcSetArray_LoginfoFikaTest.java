package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.junit.jupiter.api.Test;

public class PDVisibleSigBuildercreateProcSetArray_LoginfoFikaTest {

    @Test
    public void testCreateProcSetArray() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        builder.createProcSetArray();
    }
}
