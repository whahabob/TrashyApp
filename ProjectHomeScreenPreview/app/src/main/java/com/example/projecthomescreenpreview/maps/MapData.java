package com.example.projecthomescreenpreview.maps;

import java.util.ArrayList;

public class MapData { // Generates and populates the ArrayList of Waste Centre data, also processes the data for use elsewhere (i.e. MapsActivity)

    // Create ArrayList

    public static ArrayList<WasteCentre> RecyclingCentres = new ArrayList<>();

    public static void main() {

        // List of the waste centres and their unique data (NOTE: latlng data currently manually input)

        WasteCentre BackwellLeisureCentre = new WasteCentre();
        BackwellLeisureCentre.Type = "Recycling Bank";
        BackwellLeisureCentre.AddressLine1 = "Backwell Leisure Centre";
        BackwellLeisureCentre.AddressLine2 = "Farleigh Road";
        BackwellLeisureCentre.Locality = "Backwell";
        BackwellLeisureCentre.Postcode = "BS48 3PB";
        BackwellLeisureCentre.MixedGlass = true;
        BackwellLeisureCentre.Paper = true;
        BackwellLeisureCentre.Cardboard = true;
        BackwellLeisureCentre.Cans = true;
        BackwellLeisureCentre.Textiles = false;
        BackwellLeisureCentre.Shoes = false;
        BackwellLeisureCentre.Plastic = true;
        BackwellLeisureCentre.Cartons = true;
        BackwellLeisureCentre.lat = 51.416291;
        BackwellLeisureCentre.lng = -2.736510;

        WasteCentre ChurchillInn = new WasteCentre();
        ChurchillInn.Type = "Recycling Bank";
        ChurchillInn.AddressLine1 = "Churchill Inn";
        ChurchillInn.AddressLine2 = "Bristol Road";
        ChurchillInn.Locality = "Churchill";
        ChurchillInn.Postcode = "BS25 5NL";
        ChurchillInn.MixedGlass = true;
        ChurchillInn.Paper = true;
        ChurchillInn.Cardboard = true;
        ChurchillInn.Cans = true;
        ChurchillInn.Textiles = false;
        ChurchillInn.Shoes = false;
        ChurchillInn.Plastic = true;
        ChurchillInn.Cartons = true;
        ChurchillInn.lat = 51.337704;
        ChurchillInn.lng = -2.787627;

        WasteCentre MountPleasantShops = new WasteCentre();
        MountPleasantShops.Type = "Recycling Bank";
        MountPleasantShops.AddressLine1 = "Mount Pleasant Shops";
        MountPleasantShops.AddressLine2 = "Heywood Road";
        MountPleasantShops.Locality = "Pill";
        MountPleasantShops.Postcode = "BS20 0EJ";
        MountPleasantShops.MixedGlass = true;
        MountPleasantShops.Paper = true;
        MountPleasantShops.Cardboard = true;
        MountPleasantShops.Cans = true;
        MountPleasantShops.Textiles = false;
        MountPleasantShops.Shoes = false;
        MountPleasantShops.Plastic = true;
        MountPleasantShops.Cartons = true;
        MountPleasantShops.lat = 51.478913;
        MountPleasantShops.lng = -2.684717;


        // Apply the waste centres to the ArrayList

        RecyclingCentres.add(BackwellLeisureCentre);
        RecyclingCentres.add(ChurchillInn);
        RecyclingCentres.add(MountPleasantShops);

    }
}
