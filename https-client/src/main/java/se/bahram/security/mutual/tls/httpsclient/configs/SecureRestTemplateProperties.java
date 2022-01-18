package se.bahram.security.mutual.tls.httpsclient.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client.ssl")
public class SecureRestTemplateProperties {
    String trustStore;
    char[] trustStorePassword;
    String keyStore;
    char[] keyPassword;
    char[] keyStorePassword;

    public String getTrustStore() {
        return trustStore;
    }

    public void setTrustStore(String trustStore) {
        this.trustStore = trustStore;
    }

    public char[] getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(char[] trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public char[] getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(char[] keyPassword) {
        this.keyPassword = keyPassword;
    }

    public char[] getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(char[] keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }
}
