import java.util.*;

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

    public static void deliteNull() {
        Iterator<Auto> it = autos.listIterator();
        while (it.hasNext()) {
            if (it.next().brand == null) {
                it.remove();
            }
        }
    }

    public static void deliteAuto() {
        Random random = new Random();
        int i = random.nextInt(autos.size());
        System.out.println("Авто " + autos.get(i).toString() + " уехал с парковки. Свободных мест " + ++place);
        autos.remove(random.nextInt(i));
    }

    public static void addNewAuto(Auto a) {
        if (a.brand == null) {
            deliteNull();
        } else {
            autos.add(a);
        }
    }
}
