package org.apache.pdfbox.pdmodel.encryption;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.encryption.StandardSecurityHandler;
import java.io.IOException;

public class StandardSecurityHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testComputeUserPasswordTriggersLogFactoryGetLog() throws IOException {
        // The static initialization of StandardSecurityHandler will trigger
        // LogFactory.getLog(StandardSecurityHandler.class) when the class is loaded.
        // We need to trigger class loading by calling the entry point method.
        
        StandardSecurityHandler handler = new StandardSecurityHandler();
        
        // Prepare minimal parameters to avoid NullPointerException
        byte[] password = new byte[0];
        byte[] owner = new byte[0];
        int permissions = 0;
        byte[] id = new byte[0];
        int encRevision = 2; // Use revision 2 to avoid complex logic
        int keyLengthInBytes = 5;
        boolean encryptMetadata = false;
        
        // This call will trigger class loading if not already loaded,
        // which executes the static initializer containing LogFactory.getLog()
        handler.computeUserPassword(
            password, 
            owner, 
            permissions, 
            id, 
            encRevision, 
            keyLengthInBytes, 
            encryptMetadata
        );
    }
}
