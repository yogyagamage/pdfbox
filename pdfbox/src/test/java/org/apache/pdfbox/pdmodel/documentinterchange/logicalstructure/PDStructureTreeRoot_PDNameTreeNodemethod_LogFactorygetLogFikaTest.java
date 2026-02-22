package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDStructureTreeRoot_PDNameTreeNodemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetIDTreeTriggersStaticInitializer() throws Exception {
        // Create a mock COSDictionary for the root object
        COSDictionary mockRootDict = Mockito.mock(COSDictionary.class);
        
        // Create a mock COSDictionary for the ID_TREE entry
        COSDictionary mockIdTreeDict = Mockito.mock(COSDictionary.class);
        
        // Configure the mock to return the ID_TREE dictionary when requested
        Mockito.when(mockRootDict.getCOSDictionary(COSName.ID_TREE))
               .thenReturn(mockIdTreeDict);
        
        // Create the PDStructureTreeRoot with the mocked root dictionary
        PDStructureTreeRoot structureTreeRoot = new PDStructureTreeRoot(mockRootDict);
        
        // Call the entry point method - this will trigger the static initializer
        // of PDNameTreeNode when PDStructureElementNameTreeNode is instantiated
        structureTreeRoot.getIDTree();
    }
}
