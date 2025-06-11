package com.acme.abastecimiento.apiproxy.soap;

import com.acme.abastecimiento.apiproxy.model.PedidoRequestJson;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

@Component
public class SoapRequestBuilder {
    private final XmlMapper xmlMapper;

    public SoapRequestBuilder(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    public String buildSoapRequest(PedidoRequestJson jsonRequest) {
        // Mapear los datos de JSON a la estructura XML esperada
        EnvioPedidoRequestXml xmlPojo = new EnvioPedidoRequestXml();
        xmlPojo.setPedido(jsonRequest.getEnviarPedido().getNumPedido());
        xmlPojo.setCantidad(jsonRequest.getEnviarPedido().getCantidadPedido());
        xmlPojo.setEan(jsonRequest.getEnviarPedido().getCodigoEAN());
        xmlPojo.setProducto(jsonRequest.getEnviarPedido().getNombreProducto());
        xmlPojo.setCedula(jsonRequest.getEnviarPedido().getNumDocumento());
        xmlPojo.setDireccion(jsonRequest.getEnviarPedido().getDireccion());

        try {
            return xmlMapper.writeValueAsString(xmlPojo);
        } catch (Exception e) {
            throw new RuntimeException("Error al construir la solicitud SOAP XML", e);
        }
    }
}
