package dev.christiano.model;

public class User {
    private String firstName;
    private String lastName;
    private String city;
    private String country;

    public User(String firstName, String lastName, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User [city=" + city + ", country=" + country + ", firstName=" + firstName + ", lastName=" + lastName
                + "]";
    }

}
