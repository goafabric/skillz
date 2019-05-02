package org.goafabric.skillz.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

    private PersonEditor personEditor;

    private final Grid<Person> grid;
    final TextField filter;

    private final Button addNewBtn;

    public MainView(PersonLogic personLogic, PersonEditor personEditor) {
        this.personLogic = personLogic;
        this.personEditor = personEditor;
        grid = new Grid<>(Person.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());

        initView();
    }

    private void initView() {
        createLayout();
        addSearchFilter();

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            personEditor.editPerson((e.getValue()));
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> personEditor.editPerson(
                Person.builder().build()));

        // Listen changes made by the editor, refresh data from backend
        personEditor.setChangeHandler(() -> {
            personEditor.setVisible(false);
            listCustomers(filter.getValue());
        });

        listCustomers(null);
    }

    private void createLayout() {
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, personEditor);

        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
    }

    private void addSearchFilter() {
        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));
    }

    private void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(personLogic.findAll());
        } else  {
            grid.setItems(personLogic.findByLastName(filterText));
        }

    }
}