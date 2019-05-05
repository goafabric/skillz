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
import org.goafabric.skillz.service.dto.Address;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.util.StringUtils;


@Route
public class MainView extends VerticalLayout {
    private PersonLogic personLogic;

    private PersonEditor personEditor;

    private final Grid<Person> grid;
    private final TextField filter;
    private final Button addNewBtn;

    public MainView(PersonLogic personLogic, PersonEditor personEditor) {
        this.personLogic = personLogic;
        this.personEditor = personEditor;
        grid = new Grid<>(Person.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New person", VaadinIcon.PLUS.create());

        initView();
    }

    private void initView() {
        createLayout();
        addSearchFilter();
        addListener();
        listCustomers(null);
    }

    private void createLayout() {
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, personEditor);

        grid.setHeight("300px");
        grid.setColumns("firstName", "lastName");
        //grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
    }

    private void addSearchFilter() {
        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));
    }

    private void addListener() {
        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            personEditor.editPerson((e.getValue()));
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> personEditor.editPerson(
                Person.builder().address(new Address()).build()));

        // Listen changes made by the editor, refresh data from backend
        personEditor.setChangeHandler(() -> {
            personEditor.setVisible(false);
            listCustomers(filter.getValue());
        });
    }

    private void listCustomers(String filterText) {
        grid.setItems(StringUtils.isEmpty(filterText)
                ? personLogic.findAll().collectList().block()
                : personLogic.findByLastName(filterText).collectList().block()
        );
    }
}