package org.goafabric.skillz.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class PersonBo {
    @Id
    private String id;

    @Indexed
    private String firstName;

    @Indexed
    private String lastName;

    private LocalDateTime birthDay;

    //@Version //optimistic locking
    //private Long version;

    @NonNull
    private AddressBo address;

    //@DBRef
    private List<SkillBo> skills;
}

