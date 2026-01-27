package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.commons.logging.LogFactory;

public class PDVisibleSigBuildermethod_LogFactorygetLogFikaTest {

    @Test
    public void testCreateInnerFormResource() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        builder.createInnerFormResource();
    }
}
