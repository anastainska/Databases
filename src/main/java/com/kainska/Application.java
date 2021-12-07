package com.kainska;

import java.sql.SQLException;
import java.text.ParseException;

public class Application {

    public static void main(String[] args) throws SQLException, ParseException {
        View view = new View();
        view.interactMenu();
    }
}
