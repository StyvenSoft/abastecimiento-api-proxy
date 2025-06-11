package com.acme.abastecimiento.apiproxy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseJson {
    @JsonProperty("enviarPedidoRespuesta")
    private PedidoDataResponse enviarPedidoRespuesta;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PedidoDataResponse {
        private String codigoEnvio;
        private String estado;
    }

    // Constructor auxiliar para simplificar creación de respuestas
    public PedidoResponseJson(String codigoEnvio, String estado) {
        this.enviarPedidoRespuesta = new PedidoDataResponse(codigoEnvio, estado);
    }
}
