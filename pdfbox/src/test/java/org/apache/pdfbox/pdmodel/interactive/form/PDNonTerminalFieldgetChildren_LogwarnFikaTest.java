package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PDNonTerminalFieldgetChildren_LogwarnFikaTest {

    @Test
    public void testGetChildrenTriggersLogWarn() throws Exception {
        PDDocument document = new PDDocument();
        PDAcroForm acroForm = new PDAcroForm(document);
        
        COSDictionary parentDict = new COSDictionary();
        parentDict.setItem(COSName.KIDS, new COSArray());
        
        PDNonTerminalField parentField = new PDNonTerminalField(acroForm, parentDict, null);
        
        COSArray kidsArray = new COSArray();
        kidsArray.add(parentDict);
        
        parentDict.setItem(COSName.KIDS, kidsArray);
        
        parentField.getChildren();
        
        document.close();
    }
}
