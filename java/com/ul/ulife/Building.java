package com.ul.ulife;

public class Building {
    private String name;
    private String description;
    private int imageResourceId;
    private double lat;
    private double lng;

    public Building(String name, String description, int imageResourceId, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.lat = lat;
        this.lng = lng;
    }


    public static final Building[] buildings = {
            new Building("CSIS", "Building with Computers", R.drawable.csis, 52.673884, -8.575639),
            new Building("Schumann", "Shoe man", R.drawable.schumann, 52.673178, -8.577900),
            new Building("Main Building", "Skislopes", R.drawable.main_building, 52.673983, -8.572005),
            new Building("Materials and Surface Science Institute (MSSI) Building", "Sunday\t\t\t\t\t\tClosed\n" + "Monday\t\t\t\t\t9a.m.–5p.m.\n" + "Tuesday\t\t\t\t\t9a.m.–5p.m.\n" + "Wednesday\t\t9a.m.–5p.m.\n" + "Thursday\t\t\t\t9a.m.–5p.m.\n" + "Friday\t\t\t\t\t\t\t9a.m.–5p.m.\n" + "Thursday\t\t\t\t9a.m.–5p.m.\n", R.drawable.mssi, 52.673381,-8.568370)
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString(){
        return this.name;
    }
}