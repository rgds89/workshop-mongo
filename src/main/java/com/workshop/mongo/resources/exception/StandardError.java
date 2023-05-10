package com.workshop.mongo.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID= 1L;

    private Long timestamp;
    private String status;
    private String error;
    private String trace;
    private String message;
    private String path;
}
