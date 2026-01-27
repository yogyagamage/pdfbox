package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.cff.CFFParser;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.util.Matrix;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.geom.AffineTransform;

class PDType1CFontmethod_LogFactorygetLogFikaTest3 {

    @Test
    void testGetStringWidthTriggersStaticInitializer() throws IOException {
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        fontDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Type1C"));
        fontDict.setItem(COSName.BASE_FONT, COSName.getPDFName("TestFont"));
        fontDict.setItem(COSName.NAME, COSName.getPDFName("TestFont"));
        
        PDType1CFont font = new PDType1CFont(fontDict);
        font.getStringWidth("test");
    }
}
