package org.goafabric.skillz.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonBo {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDay;

    //@Version //optimistic locking
    //private Long version;

    @NonNull
    private AddressBo address;

    List<SkillBo> skills;
}

