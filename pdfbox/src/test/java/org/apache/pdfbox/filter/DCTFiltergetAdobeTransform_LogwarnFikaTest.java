package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.imageio.metadata.IIOMetadata;
import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DCTFiltergetAdobeTransform_LogwarnFikaTest {

    @Test
    void testGetAdobeTransform() throws Exception {
        // Create mock IIOMetadata
        IIOMetadata metadata = mock(IIOMetadata.class);
        
        // Create mock DOM structure
        Element tree = mock(Element.class);
        Element markerSequence = mock(Element.class);
        NodeList app14AdobeNodeList = mock(NodeList.class);
        Element adobeElement = mock(Element.class);
        
        // Setup the DOM hierarchy
        when(metadata.getAsTree("javax_imageio_jpeg_image_1.0")).thenReturn(tree);
        when(tree.getElementsByTagName("markerSequence")).thenReturn(mock(NodeList.class));
        when(tree.getElementsByTagName("markerSequence").item(0)).thenReturn(markerSequence);
        when(markerSequence.getElementsByTagName("app14Adobe")).thenReturn(app14AdobeNodeList);
        
        // Setup app14AdobeNodeList to have length > 1 to trigger the warning
        when(app14AdobeNodeList.getLength()).thenReturn(2);
        when(app14AdobeNodeList.item(1)).thenReturn(adobeElement);
        when(adobeElement.getAttribute("transform")).thenReturn("1");
        
        // Use reflection to access the private method
        Class<?> clazz = Class.forName("org.apache.pdfbox.filter.DCTFilter");
        Method method = clazz.getDeclaredMethod("getAdobeTransform", IIOMetadata.class);
        method.setAccessible(true);
        
        // Create a real DCTFilter instance
        Object dctFilter = clazz.getDeclaredConstructor().newInstance();
        
        // Invoke the method - this should trigger LOG.warn when app14AdobeNodeListLength > 1
        method.invoke(dctFilter, metadata);
    }
}
