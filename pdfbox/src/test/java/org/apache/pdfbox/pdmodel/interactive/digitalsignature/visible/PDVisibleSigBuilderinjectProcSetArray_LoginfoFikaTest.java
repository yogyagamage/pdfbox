package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDVisibleSigBuilderinjectProcSetArray_LoginfoFikaTest {

    @Test
    public void testInjectProcSetArray() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        PDResources innerFormResources = new PDResources();
        PDResources imageFormResources = new PDResources();
        PDResources holderFormResources = new PDResources();
        
        PDStream innerFormStream = new PDStream(document);
        PDFormXObject innerForm = new PDFormXObject(innerFormStream);
        innerForm.setResources(innerFormResources);
        innerForm.setBBox(new PDRectangle());
        innerForm.setFormType(1);
        
        COSArray procSet = new COSArray();
        procSet.add(COSName.getPDFName("PDF"));
        procSet.add(COSName.getPDFName("Text"));
        procSet.add(COSName.getPDFName("ImageB"));
        procSet.add(COSName.getPDFName("ImageC"));
        procSet.add(COSName.getPDFName("ImageI"));
        
        builder.injectProcSetArray(innerForm, page, innerFormResources, 
                                  imageFormResources, holderFormResources, procSet);
        
        document.close();
    }
}
