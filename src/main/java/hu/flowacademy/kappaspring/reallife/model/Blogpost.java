package hu.flowacademy.kappaspring.reallife.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true) // toBuilder egy copy metodus lesz
@NoArgsConstructor
@AllArgsConstructor
public class Blogpost {
    private String id;
    private String title;
    private String description;
    private String publisher;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
