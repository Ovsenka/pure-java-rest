package org.ovsenka.app.api;

import com.sun.net.httpserver.Headers;

import lombok.Value;

@Value
public class ResponseEntity<T> {

    private T body;
    private Headers headers;
    private StatusCode statusCode;
}
