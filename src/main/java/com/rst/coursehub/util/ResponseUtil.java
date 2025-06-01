package com.rst.coursehub.util;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseUtil {

    public static <T> ResponseEntity<T> wrapOrNotFound(Optional<T> maybeResponse) {
        return maybeResponse
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
