package org.goafabric.skillz.persistence.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class PersonBo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(name = "birthday")
    private LocalDateTime birthDay;

    //@Version //optimistic locking
    //private Long version;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NonNull
    private AddressBo address;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "person")
    @NonNull
    private List<SkillBo> skills;

    //what a shoehorn of hoseshit is this ?!?!? i have to do this myself ?!
    public void setSkills(List<SkillBo> skills) {
        if (skills != null) {
            skills.stream().forEach(skill -> skill.setPerson(this));
            this.skills = skills;
        }
    }
}

