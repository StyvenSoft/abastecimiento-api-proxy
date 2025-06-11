package com.acme.abastecimiento.apiproxy.soap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "EnvioPedidoResponse")
public class EnvioPedidoResponseXml {
    @JacksonXmlProperty(localName = "Codigo")
    private String codigo;

    @JacksonXmlProperty(localName = "Mensaje")
    private String mensaje;
}
