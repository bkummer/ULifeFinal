package com.ul.ulife;

public class Restaurant {
    private double  lat;
    private double  lng;
    private String  name;
    private String  description;
    private int     imageResourceId;


    public Restaurant(String name, String description, int imageResourceId, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.lat = lat;
        this.lng = lng;
    }


    public static final Restaurant[] restaurantsOnCampus = {
            new Restaurant("Spar", "Great deli, hot food served all day!", R.drawable.csis, 52.673114, -8.569822),
            new Restaurant("The Pavilion", "Shoe man", R.drawable.pavilion, 52.679172, -8.569731),
            new Restaurant("The Stables", "", R.drawable.main_building, 52.673249, -8.570999),
            new Restaurant("Eden", "Sunday\t\t\t\t\t\tClosed\n" + "Monday\t\t\t\t\t9a.m.–5p.m.\n" + "Tuesday\t\t\t\t\t9a.m.–5p.m.\n" + "Wednesday\t\t9a.m.–5p.m.\n" + "Thursday\t\t\t\t9a.m.–5p.m.\n" + "Friday\t\t\t\t\t\t\t9a.m.–5p.m.\n" + "Thursday\t\t\t\t9a.m.–5p.m.\n", R.drawable.eden, 52.674344,-8.571870),
            new Restaurant("Subway", "Quick And Tasty Subs!", R.drawable.main_building, 52.673602, -8.570738),
            new Restaurant("The Pizza Co", "Best Pizza On Campus!", R.drawable.pizzaco, 52.675794, -8.576415)
    };

    public static final Restaurant[] restaurantsNearCampus = {
            new Restaurant("Lana", "Healthy And Delicious Asian Cuisine", R.drawable.lana, 52.667369, -8.557835),
            new Restaurant("Bella Italia", "Delicious Italian Food!", R.drawable.bellaitalia, 52.666270, -8.553233),
            new Restaurant("Delish Cafe", "Cute And Cosy Cafe With Great Coffee", R.drawable.delish, 52.667677, -8.575728),
            new Restaurant("Rios", "Best Chipper Around!", R.drawable.rios, 52.668043, -8.555253),
            new Restaurant("Four Seasons", "Tasty And Affordable Take Away Pizza!", R.drawable.fourseasons, 52.663773, -8.578767)
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

