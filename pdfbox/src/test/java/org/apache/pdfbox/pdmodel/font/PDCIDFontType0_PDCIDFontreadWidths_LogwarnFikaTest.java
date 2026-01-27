package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDCIDFontType0;
import org.apache.commons.logging.Log;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.fontbox.cff.CFFCharset;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.cff.CFFParser;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.cff.CIDKeyedType2CharString;
import org.apache.fontbox.cff.Type1CharString;
import org.apache.fontbox.cff.Type2CharString;
import org.apache.fontbox.ttf.CFFTable;
import org.apache.fontbox.ttf.OpenTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.Matrix;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PDCIDFontType0_PDCIDFontreadWidths_LogwarnFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        COSDictionary fontDictionary = new COSDictionary();
        fontDictionary.setItem(COSName.TYPE, COSName.FONT);
        fontDictionary.setItem(COSName.SUBTYPE, COSName.CID_FONT_TYPE0);
        fontDictionary.setItem(COSName.BASE_FONT, COSName.getPDFName("TestFont"));
        
        COSArray wArray = new COSArray();
        wArray.add(COSName.getPDFName("NotANumber"));
        wArray.add(new COSArray());
        fontDictionary.setItem(COSName.W, wArray);
        
        PDType0Font parent = mock(PDType0Font.class);
        
        PDCIDFontType0 font = new PDCIDFontType0(fontDictionary, parent);
    }
}
