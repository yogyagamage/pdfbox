package org.apache.pdfbox.pdmodel.interactive.form;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.commons.logging.Log;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.cos.COSObject;
import java.util.List;

public class PDNonTerminalFieldgetChildren_LogwarnFikaTest {

    @Test
    public void testGetChildrenTriggersLogWarn() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            COSDictionary fieldDict = new COSDictionary();
            fieldDict.setItem(COSName.KIDS, new COSArray());
            
            PDNonTerminalField parentField = new PDNonTerminalField(acroForm, fieldDict, null);
            
            COSArray kidsArray = new COSArray();
            kidsArray.add(parentField.getCOSObject());
            fieldDict.setItem(COSName.KIDS, kidsArray);
            
            parentField.getChildren();
        }
    }
}
