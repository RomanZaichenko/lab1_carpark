package kpi.lab1;

import java.util.Objects;

public class Manufacturer {
    private String name;
    private String country;


    public Manufacturer(String name, String country) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = name;
        }

        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        } else {
            this.country = country;
        }

    }

    public String getName() { return name; }
    public String getCountry() { return country; }

    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer manufacturerToCompare)) return false;
        return name.equalsIgnoreCase(manufacturerToCompare.name) && country.equalsIgnoreCase(manufacturerToCompare.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
