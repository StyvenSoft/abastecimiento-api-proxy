package com.acme.abastecimiento.apiproxy.controller;

import com.acme.abastecimiento.apiproxy.model.PedidoRequestJson;
import com.acme.abastecimiento.apiproxy.model.PedidoResponseJson;
import com.acme.abastecimiento.apiproxy.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Endpoint: POST http://localhost:8080/api/pedidos/enviar
     *
     * @param request El cuerpo de la petición JSON, mapeado a PedidoRequestJson.
     * @return ResponseEntity conteniendo PedidoResponseJson y el estado HTTP.
     */
    @PostMapping("/enviar")
    public ResponseEntity<PedidoResponseJson> enviarPedido(@RequestBody PedidoRequestJson request) {
        PedidoResponseJson response = pedidoService.procesarPedido(request);
        // Retorna la respuesta estado 200
        return ResponseEntity.ok(response);
    }
}
