package org.goafabric.skillz.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class AddressBo {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String street;
    private String city;
}
