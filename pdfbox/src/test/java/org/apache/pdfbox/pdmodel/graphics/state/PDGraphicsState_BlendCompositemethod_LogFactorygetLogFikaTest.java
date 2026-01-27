package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDGraphicsState_BlendCompositemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetStrokingJavaCompositeTriggersLogFactoryGetLog() {
        PDRectangle page = new PDRectangle(595, 842);
        PDGraphicsState graphicsState = new PDGraphicsState(page);
        
        graphicsState.setBlendMode(BlendMode.NORMAL);
        graphicsState.setAlphaConstant(0.5);
        
        graphicsState.getStrokingJavaComposite();
    }
}
