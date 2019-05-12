package org.goafabric.skillz.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.joda.time.LocalDateTime;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String id;
    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDay;

    @NonNull
    private Address address;

    private List<Skill> skills;
}
