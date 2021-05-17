package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class CategoriesMenu {

    private State state;

}
