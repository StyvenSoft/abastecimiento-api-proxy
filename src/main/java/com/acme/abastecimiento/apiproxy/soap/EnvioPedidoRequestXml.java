package com.acme.abastecimiento.apiproxy.soap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "EnvioPedidoRequest")
public class EnvioPedidoRequestXml {
    @JacksonXmlProperty(localName = "pedido")
    private String pedido;

    @JacksonXmlProperty(localName = "Cantidad")
    private String cantidad;

    @JacksonXmlProperty(localName = "EAN")
    private String ean;

    @JacksonXmlProperty(localName = "Producto")
    private String producto;

    @JacksonXmlProperty(localName = "Cedula")
    private String cedula;

    @JacksonXmlProperty(localName = "Direccion")
    private String direccion;
}
