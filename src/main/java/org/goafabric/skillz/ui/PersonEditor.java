package org.goafabric.skillz.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.goafabric.skillz.logic.PersonLogic;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class PersonEditor extends VerticalLayout implements KeyNotifier {

    private final PersonLogic personLogic;

    /**
     * The currently edited person
     */
    private Person person;

    /* Fields to edit properties in person entity */
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");

    /* Action buttons */
    // TODO why more code?
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Person> binder = new Binder<>(Person.class);
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public PersonEditor(PersonLogic personLogic) {
        this.personLogic = personLogic;

        add(firstName, lastName, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editPerson(person));
        setVisible(false);
    }

    void delete() {
        personLogic.delete(person.getId());
        changeHandler.onChange();
    }

    void save() {
        personLogic.save(person);
        changeHandler.onChange();
    }


    public final void editPerson(Person person) {
        if (person == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = person.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            this.person = personLogic.getById(person.getId());
        }
        else {
            this.person = person;
        }

        cancel.setVisible(persisted);
        binder.setBean(this.person); // Bind person properties to similarly named fields

        setVisible(true);
        firstName.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h; // ChangeHandler is notified when either save or delete
    }

}