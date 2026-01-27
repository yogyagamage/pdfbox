package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PDObjectReferencemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetReferencedObjectTriggersLogFactoryGetLog() throws IOException {
        // Create a COSStream mock that will trigger the static initializer
        COSStream cosStream = mock(COSStream.class);
        when(cosStream.getCOSDictionary(COSName.OBJ)).thenReturn(cosStream);
        when(cosStream.getCOSName(COSName.TYPE)).thenReturn(COSName.ANNOT);
        
        // Create a COSDictionary that will return our stream
        COSDictionary dict = mock(COSDictionary.class);
        when(dict.getCOSDictionary(COSName.OBJ)).thenReturn(cosStream);
        
        // Create PDObjectReference with the mocked dictionary
        PDObjectReference pdObjectReference = new PDObjectReference(dict);
        
        // This call will trigger the static initializer which calls LogFactory.getLog
        // and then execute getReferencedObject()
        COSObjectable result = pdObjectReference.getReferencedObject();
    }
}
