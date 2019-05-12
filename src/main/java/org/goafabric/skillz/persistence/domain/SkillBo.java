package org.goafabric.skillz.persistence.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillBo {
    @Id
    private String id;

    private String name;
    private String description;

    //private PersonBo person;
}
