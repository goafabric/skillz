package org.goafabric.skillz.persistence.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="skill")
public class SkillBo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private PersonBo person;
}
