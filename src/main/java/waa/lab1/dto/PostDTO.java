package waa.lab1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include. NON_NULL)
public record PostDTO(long id, String title, String content, String author, Long userId) {
}
