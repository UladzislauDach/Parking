import java.util.ArrayList;

class Parking {
    private static ArrayList<Auto> autos = new ArrayList<>();
    static int place;

    Parking(ArrayList<Auto> autos) {
        Parking.autos = autos;
    }

    static ArrayList<Auto> getAutos() {
        return autos;
    }

    static void setAutos(ArrayList<Auto> autos) {
        Parking.autos = autos;
    }

    static int getPlace() {
        return place;
    }

    static void setPlace(int place) {
        Parking.place = place;
    }


    static void deliteNull() {
        autos.removeIf(auto -> auto.brand == null);
    }
}