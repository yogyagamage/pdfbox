package org.apache.pdfbox.pdmodel.common.function;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDFunction_PDFunctionType0method_LogFactorygetLogFikaTest {

    @Test
    public void testCreateTriggersPDFunctionType0StaticInitializer() throws IOException {
        // Create a COSDictionary that represents a Type 0 function
        COSDictionary functionDict = new COSDictionary();
        functionDict.setItem(COSName.TYPE, COSName.FUNCTION);
        functionDict.setInt(COSName.FUNCTION_TYPE, 0);
        
        // Call the entry point method which should trigger PDFunctionType0.<clinit>()
        PDFunction.create(functionDict);
    }
}
