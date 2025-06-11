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

    public PedidoResponseJson parseSoapResponse(String xmlResponse) {
        try {
            EnvioPedidoResponseXml xmlPojo = xmlMapper.readValue(xmlResponse, EnvioPedidoResponseXml.class);

            return new PedidoResponseJson(xmlPojo.getCodigo(), xmlPojo.getMensaje());
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear la respuesta SOAP XML", e);
        }
    }
}
