package com.acme.abastecimiento.apiproxy.service;

import com.acme.abastecimiento.apiproxy.model.PedidoRequestJson;
import com.acme.abastecimiento.apiproxy.model.PedidoResponseJson;
import com.acme.abastecimiento.apiproxy.soap.SoapRequestBuilder;
import com.acme.abastecimiento.apiproxy.soap.SoapResponseParser;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final SoapRequestBuilder soapRequestBuilder;
    private final SoapResponseParser soapResponseParser;

    // Constructor para que Spring inyecte las dependencias de los constructores/parsers SOAP
    public PedidoService(SoapRequestBuilder soapRequestBuilder, SoapResponseParser soapResponseParser) {
        this.soapRequestBuilder = soapRequestBuilder;
        this.soapResponseParser = soapResponseParser;
    }

    public PedidoResponseJson procesarPedido(PedidoRequestJson jsonRequest) {
        String xmlRequestString;
        try {
            xmlRequestString = soapRequestBuilder.buildSoapRequest(jsonRequest);
            System.out.println("XML Request generado para SOAP:\n" + xmlRequestString);
        } catch (RuntimeException e) {
            System.err.println("Error al construir el XML de solicitud: " + e.getMessage());
            return new PedidoResponseJson("ERROR_XML_BUILD", "Error interno al preparar la solicitud.");
        }

        // Simular la llamada al servicio SOAP externo
        // El endpoint del ejercicio es un mock no disponible, se crea simulación de respuesta.
        String mockXmlResponse = "<EnvioPedidoResponse><Codigo>80375472</Codigo><Mensaje>Entregado exitosamente al cliente</Mensaje></EnvioPedidoResponse>";
        System.out.println("Mock XML Response recibido:\n" + mockXmlResponse); // Para depuración

        // Parsear la respuesta XML a JSON Response
        try {
            return soapResponseParser.parseSoapResponse(mockXmlResponse);
        } catch (RuntimeException e) {
            System.err.println("Error al parsear la respuesta XML del servicio externo: " + e.getMessage());
            return new PedidoResponseJson("ERROR_XML_PARSE", "Error al procesar la respuesta del servicio externo.");
        }
    }
}
