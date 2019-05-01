package org.goafabric.skillz.service;

import lombok.experimental.Delegate;
import org.goafabric.skillz.logic.PersonLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PersonService.RESOURCE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonServiceBean implements PersonService {
    @Autowired
    @Delegate
    private PersonLogic personLogic;
}
