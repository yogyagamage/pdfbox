package org.apache.pdfbox.pdmodel.graphics.blend;

import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.junit.jupiter.api.Test;

public class BlendCompositegetInstance_LogwarnFikaTest {

    @Test
    public void testGetInstanceWithNegativeAlphaTriggersLogWarn() {
        BlendComposite.getInstance(BlendMode.NORMAL, -0.5f);
    }
}
