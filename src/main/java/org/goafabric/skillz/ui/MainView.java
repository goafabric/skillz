package org.goafabric.skillz.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.goafabric.skillz.logic.PersonLogic;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.util.StringUtils;


@Route
public class MainView extends VerticalLayout {
    private PersonLogic personLogic;

    private final Grid<Person> grid;

    public MainView(PersonLogic personLogic) {
        this.personLogic = personLogic;
        grid = new Grid<>(Person.class);
        add(grid);

        listCustomers("");
        addSearchFilter();
    }

    private void addSearchFilter() {
        TextField filter = new TextField();
        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));
        add(filter, grid);
    }

    private void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(personLogic.findAll());
        } else  {
            grid.setItems(personLogic.findByLastName(filterText));
        }

    }
}