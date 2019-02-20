import java.util.ArrayList;

public class Parking {
    static ArrayList<Auto> autos = new ArrayList<>();
    static int place = 50;

    public Parking(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public void printAutoInParking() {
        for (Auto a : autos) {
            System.out.println(a.toString());
        }
    }

    public static void deleteNull() {
        for (Auto a : autos){
            if (a.brand.equals("qwerty")) {
                autos.remove(a);

            }
        }
    }
}





