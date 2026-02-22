package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;

public class PDVisibleSigBuildermethod_LogFactorygetLogFikaTest3 {

    @Test
    public void testCreateFormatterRectangleTriggersStaticInitializer() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        int[] params = {0, 0, 100, 100};
        builder.createFormatterRectangle(params);
    }
}
