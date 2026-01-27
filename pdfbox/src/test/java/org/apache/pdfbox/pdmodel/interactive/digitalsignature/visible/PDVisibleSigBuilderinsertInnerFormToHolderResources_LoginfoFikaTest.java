package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

import java.io.IOException;

public class PDVisibleSigBuilderinsertInnerFormToHolderResources_LoginfoFikaTest {

    @Test
    public void testInsertInnerFormToHolderResources() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        try (PDDocument doc = new PDDocument()) {
            COSStream stream = doc.getDocument().createCOSStream();
            PDFormXObject innerForm = new PDFormXObject(stream);
            
            PDResources holderFormResources = new PDResources();
            
            builder.insertInnerFormToHolderResources(innerForm, holderFormResources);
        }
    }
}
