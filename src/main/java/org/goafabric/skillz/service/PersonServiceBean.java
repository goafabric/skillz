package org.goafabric.skillz.service;

import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.goafabric.skillz.logic.PersonLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = PersonService.RESOURCE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@Transactional
@Slf4j
public class PersonServiceBean implements PersonService {
    @Autowired
    @Delegate
    private PersonLogic personLogic;
}
