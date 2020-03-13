package com.turkishairlines;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Passenger {
    private String tcNo;
    private String name;
    private String lastName;
    private String Phone;
    private String email;
    private String dateOfBirth;

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public ArrayList<Passenger> getPassengers() {
        MySqlDatabase database = new MySqlDatabase("root", "Ankara01!", "TurkHavaYollari");
        ArrayList<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger();

        try {
            ResultSet result = database.resultSet("SELECT * FROM YolcuBilgileri");
            while (result.next()) {
                passenger.setTcNo(result.getString("TcNo"));
                passenger.setName(result.getString("Ad"));
                passenger.setLastName(result.getString("Soyad"));
                passenger.setPhone(result.getString("CepTelefonu"));
                passenger.setDateOfBirth(result.getString("DogumTarihi"));
                passenger.setEmail(result.getString("Eposta"));
                passengers.add(passenger);
                passenger = new Passenger();
            }
            database.close();
            return passengers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
