# Abastecimiento API Proxy

Se expone una API REST con mensajería json en Spring Boot para facilitar la comunicación entre el ejercicio de sistema cliente que envía pedidos en formato JSON y un servicio (simulado) que espera y devuelve información en formato XML. Se realiza las transformaciones de datos necesarias teniendo en cuenta la tabla de mapeo del ejercicio.

## Descripción prueba springboot

Ejercicio Práctico:

1.  Se realiza exposición de un endpoint RESTful para JSON: Endpoint RESTful que está configurado para aceptar la solicitud de pedidos del ejercicio en formato JSON.
2.  Transformación de la petición de JSON a XML: Una vez que la API recibe la petición JSON, implementé la lógica para tomar esa estructura de datos y transformarla a un formato XML específico.
3.  Simulación de interacción SOAP: Debido a que es un ejercicio, la comunicación con el sistema de envío de pedidos externo se realizó mediante una simulación. En lugar de hacer una llamada SOAP real a un servicio externo indicado en Endpoint: https://run.mocky.io/v3/19217075-6d4e-4818-98bc-416d1feb7b84 no disponible, genere una respuesta XML mockeada. Esta respuesta simula con el XML que el sistema externo (SOAP) devolvería
4.  Transformación de la respuesta de XML a JSON: Una vez que se recibe la respuesta XML simulada, implementé la transformación inversa. que es convertida de nuevo a un formato JSON, que es el que se retorna al cliente original

## Tecnologías

* Framework: Spring Boot (JAVA)
* Gestor de Dependencias: Apache Maven
* Serialización/Deserialización: Jackson (para JSON y XML)
* Librerías: Lombok (para POJOs concisos)
* Contenerización: Archivo docker

## Compilar/ Ejecutar con Docker

Para ejecutar usando Docker:

1.  Docker instalado y corriendo.
2.  Clonar repositorio:
    ```bash
    git clone https://github.com/StyvenSoft/abastecimiento-api-proxy.git
    cd abastecimiento-api-proxy
    ```
3.  Construir la imagen Docker:
    En la terminal en la raíz del proyecto ejecutar los comandos:
    ```bash
    docker build -t abastecimiento-api-proxy .
    ```
    
    ```bash
    docker run -p 8080:8080 abastecimiento-api-proxy
    ```

## Endpoint de la API

La API expone el endpoint para el envío de pedidos:

* Método: POST
* URL: http://localhost:8080/api/pedidos/enviar
* Content-Type: application/json

### Petición (JSON Request)

```json
{
	"enviarPedido": {
		"numPedido": "75630275",
		"cantidadPedido": "1",
		"codigoEAN": "00110000765191002104587",
		"nombreProducto": "Armario INVAL",
		"numDocumento": "1113987400",
		"direccion": "CR 72B 45 12 APT 301"
	}
}
```

### Respuesta (JSON Response)

```json
{
  "enviarPedidoRespuesta": {
    "codigoEnvio": "80375472",
    "estado": "Entregado exitosamente al cliente"
  }
}
```
