package org.apache.pdfbox.pdmodel.encryption;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.encryption.StandardSecurityHandler;
import java.io.IOException;

class StandardSecurityHandler_SecurityHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testComputeUserPasswordTriggersLogFactoryGetLog() throws IOException {
        StandardSecurityHandler handler = new StandardSecurityHandler();
        
        byte[] password = new byte[] { 1, 2, 3 };
        byte[] owner = new byte[] { 4, 5, 6 };
        int permissions = 0;
        byte[] id = new byte[] { 7, 8, 9 };
        int encRevision = 2;
        int keyLengthInBytes = 5;
        boolean encryptMetadata = false;
        
        handler.computeUserPassword(password, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);
    }
}
