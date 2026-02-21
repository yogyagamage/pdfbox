package org.apache.pdfbox.pdmodel.graphics.blend;

import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.junit.jupiter.api.Test;

class BlendCompositegetInstance_LogwarnFikaTest {

    @Test
    void test() {
        BlendComposite.getInstance(BlendMode.NORMAL, -0.5f);
    }
}
