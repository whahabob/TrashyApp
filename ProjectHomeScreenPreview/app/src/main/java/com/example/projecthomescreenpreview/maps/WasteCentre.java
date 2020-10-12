package com.example.projecthomescreenpreview.maps;

public class WasteCentre {

    // Declares all the strings, coordinates and booleans that make up the location and recycling information data

    public String Type;
    public String AddressLine1;
    public String AddressLine2;
    public String Locality;
    public String Postcode;
    public Boolean MixedGlass;
    public Boolean Paper;
    public Boolean Cardboard;
    public Boolean Cans;
    public Boolean Textiles;
    public Boolean Shoes;
    public Boolean Plastic;
    public Boolean Cartons;
    public double lat;
    public double lng;

    public StringBuilder markerString = new StringBuilder();

    public WasteCentre(){}
}
