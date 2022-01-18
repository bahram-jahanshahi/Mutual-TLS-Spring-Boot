package se.bahram.security.mutual.tls.httpsclient;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import se.bahram.security.mutual.tls.httpsclient.configs.SecureRestTemplateProperties;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.net.URL;

@SpringBootApplication
@EnableConfigurationProperties(SecureRestTemplateProperties.class)
public class HttpsClientApplication implements CommandLineRunner {

    final SecureRestTemplateProperties properties;

    public HttpsClientApplication(SecureRestTemplateProperties properties) {
        this.properties = properties;
    }

    public static void main(String[] args) {
        SpringApplication.run(HttpsClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(new ClassPathResource(properties.getTrustStore()).getFile(), properties.getTrustStorePassword())
                .loadKeyMaterial(new ClassPathResource(properties.getKeyStore()).getFile(), properties.getKeyStorePassword(), properties.getKeyPassword())
                .setProtocol("TLSv1.3")
                .build();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(
                new HttpComponentsClientHttpRequestFactory(
                        HttpClientBuilder.create()
                                .setSSLContext(sslContext)
                                .build()
                )
        );
        ResponseEntity<String> response = restTemplate
                .exchange("https://localhost:8443/https/hello/bahram", HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}

