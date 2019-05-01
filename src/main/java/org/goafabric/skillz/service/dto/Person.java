package org.goafabric.skillz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //private LocalDateTime birthDay;
}
