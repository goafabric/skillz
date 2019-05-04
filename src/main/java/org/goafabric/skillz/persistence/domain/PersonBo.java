package org.goafabric.skillz.persistence.domain;

import lombok.Data;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;

@Data
public class PersonBo {
    //private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDay;

    //@Version //optimistic locking
    //private Long version;

    /*
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NonNull
    private AddressBo address;

     */
}

