package org.goafabric.skillz.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonBo {
    private static final long serialVersionUID = 1L;

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

    @Version //optimistic locking
    private Long version;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NonNull
    private AddressBo address;
}

