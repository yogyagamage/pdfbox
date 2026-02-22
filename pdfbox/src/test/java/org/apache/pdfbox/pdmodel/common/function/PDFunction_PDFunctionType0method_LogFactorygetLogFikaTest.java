package org.apache.pdfbox.pdmodel.common.function;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDFunction_PDFunctionType0method_LogFactorygetLogFikaTest {

    @Test
    public void testCreateTriggersLogFactoryGetLog() throws IOException {
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockDict.getInt(COSName.FUNCTION_TYPE)).thenReturn(0);
        
        PDFunction.create(mockDict);
    }
}
