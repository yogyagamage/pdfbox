package org.apache.pdfbox.pdmodel.encryption;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.jupiter.api.Test;

public class PublicKeySecurityHandlercreateDERForRecipient_ContentInfomethodFikaTest {

    @Test
    public void createDERForRecipientShouldInvokeContentInfoConstructor() throws Exception {
        Provider provider = new BouncyCastleProvider();
        if (Security.getProvider(provider.getName()) == null) {
            Security.addProvider(provider);
        }

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", provider);
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        X500Name name = new X500Name("CN=Test");
        Date notBefore = new Date(System.currentTimeMillis() - 10000L);
        Date notAfter = new Date(System.currentTimeMillis() + 10000L);

        JcaX509v3CertificateBuilder certificateBuilder = new JcaX509v3CertificateBuilder(
                name,
                BigInteger.ONE,
                notBefore,
                notAfter,
                name,
                keyPair.getPublic());

        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA")
                .setProvider(provider)
                .build(keyPair.getPrivate());

        X509CertificateHolder certificateHolder = certificateBuilder.build(signer);
        X509Certificate certificate = new JcaX509CertificateConverter()
                .setProvider(provider)
                .getCertificate(certificateHolder);

        PublicKeySecurityHandler securityHandler = new PublicKeySecurityHandler();
        Method method = PublicKeySecurityHandler.class.getDeclaredMethod(
                "createDERForRecipient", byte[].class, X509Certificate.class);
        method.setAccessible(true);
        method.invoke(securityHandler, new byte[16], certificate);
    }
}
