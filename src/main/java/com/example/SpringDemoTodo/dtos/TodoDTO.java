package com.example.SpringDemoTodo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TodoDTO - Data Transfer Object for Todo Requests
 *
 * This DTO is used for transferring todo data in HTTP request bodies from the client.
 * It decouples the REST API contract from the internal Todo entity model, allowing:
 * - Flexible changes to internal model without affecting API clients
 * - Explicit control over which fields are exposed to clients
 * - Validation of input data at the boundary layer
 *
 * Lombok @Data annotation generates getters, setters, equals(), hashCode(), and toString()
 */
@Data
@AllArgsConstructor
public class TodoDTO {
    // The content/description of the todo item to be created or updated
    private String content;
}
