package com.turkishairlines;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Route {
    private String from;
    private String to;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ArrayList<Route> getRoutes() {
        MySqlDatabase database = new MySqlDatabase("root", "Ankara01!", "TurkHavaYollari");
        ArrayList<Route> routes = new ArrayList<>();
        Route route = new Route();

        try {
            ResultSet result = database.resultSet("SELECT * FROM UcusYonu");
            while (result.next()) {
                route.setFrom(result.getString("Kalkis"));
                route.setTo(result.getString("Varis"));
                routes.add(route);
                route = new Route();
            }
            return routes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
