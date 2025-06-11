package com.acme.abastecimiento.apiproxy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestJson {
    // @JsonProperty para mapear el nombre del campo JSON al nombre de la variable Java
    @JsonProperty("enviarPedido")
    private PedidoDataRequest enviarPedido;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PedidoDataRequest {
        private String numPedido;
        private String cantidadPedido;
        private String codigoEAN;
        private String nombreProducto;
        private String numDocumento;
        private String direccion;
    }
}
