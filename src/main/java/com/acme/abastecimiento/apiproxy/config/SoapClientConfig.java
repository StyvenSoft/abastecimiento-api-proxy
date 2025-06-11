package com.acme.abastecimiento.apiproxy.config;

import com.fasterxml.jackson.databind.ObjectMapper; // Importa el ObjectMapper para JSON
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter; // Importa para el convertidor de mensajes

@Configuration
public class SoapClientConfig {
    @Bean
    public XmlMapper xmlMapper() {
        // Instancia básica para la transformación.
        return new XmlMapper();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Convertidor de mensajes le asigna el ObjectMapper de JSON
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        return converter;
    }
}
