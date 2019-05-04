package org.goafabric.skillz.persistence.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AddressBo {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String street;
    private String city;
}
