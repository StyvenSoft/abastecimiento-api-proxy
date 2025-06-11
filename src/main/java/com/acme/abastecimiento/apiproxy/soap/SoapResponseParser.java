package com.acme.abastecimiento.apiproxy.soap;

import com.acme.abastecimiento.apiproxy.model.PedidoResponseJson;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

@Component
public class SoapResponseParser {
    private final XmlMapper xmlMapper;

    public SoapResponseParser(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    /**
     * Parsea respuesta XML del servicio SOAP y la transforma en JSON de respuesta.
     *
     * @param xmlResponse Una cadena que contiene el XML de la respuesta del servicio SOAP.
     * @return Objeto PedidoResponseJson con los datos parseados.
     * @throws RuntimeException si ocurre un error durante la deserialización del XML o el mapeo.
     */
    public PedidoResponseJson parseSoapResponse(String xmlResponse) {
        try {
            EnvioPedidoResponseXml xmlPojo = xmlMapper.readValue(xmlResponse, EnvioPedidoResponseXml.class);

            return new PedidoResponseJson(xmlPojo.getCodigo(), xmlPojo.getMensaje());
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear la respuesta SOAP XML", e);
        }
    }
}
