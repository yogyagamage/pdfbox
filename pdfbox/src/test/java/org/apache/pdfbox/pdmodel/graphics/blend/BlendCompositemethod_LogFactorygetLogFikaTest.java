package org.apache.pdfbox.pdmodel.graphics.blend;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;

class BlendCompositemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetInstanceTriggersStaticInitializer() {
        BlendComposite.getInstance(BlendMode.NORMAL, 0.5f);
    }
}
