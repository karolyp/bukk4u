package hu.rendszerfejlesztes.bookshopbackend.ui;

import com.google.common.collect.Lists;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private UserRepository repo;
    private Grid<User> grid;

    @Autowired
    public VaadinUI(UserRepository repo) {
        this.repo = repo;
        this.grid = new Grid<>(User.class);
    }

    private void listUsers() {
        grid.setItems(Lists.newArrayList(repo.findAll()));
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(grid);
        listUsers();
    }
}
