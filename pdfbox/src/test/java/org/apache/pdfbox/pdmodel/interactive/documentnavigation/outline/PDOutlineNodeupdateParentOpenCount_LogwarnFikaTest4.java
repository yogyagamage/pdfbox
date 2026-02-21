package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class PDOutlineNodeupdateParentOpenCount_LogwarnFikaTest4 {

    @Test
    void testUpdateParentOpenCountTriggersLogWarn() throws Exception {
        // Create a parent node that will point to itself
        PDOutlineNode parent = Mockito.mock(PDOutlineNode.class,
                Mockito.withSettings()
                        .useConstructor()
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        
        // Create a child node that inherits from parent
        PDOutlineNode child = Mockito.mock(PDOutlineNode.class,
                Mockito.withSettings()
                        .useConstructor()
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        
        // Set up the self-referential condition
        when(child.getParent()).thenReturn(parent);
        when(child.getCOSObject()).thenReturn(mock(org.apache.pdfbox.cos.COSDictionary.class));
        when(parent.getCOSObject()).thenAnswer(invocation -> child.getCOSObject());
        when(parent.isNodeOpen()).thenReturn(true);
        when(parent.getOpenCount()).thenReturn(0);
        
        // This should trigger the LOG.warn call
        child.updateParentOpenCount(1);
    }
}
