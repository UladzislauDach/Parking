import java.util.*;

public class Parking {
    static ArrayList<Auto> autos = new ArrayList<>();
    static int place;

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
        autos.remove(i);
    }

    public static void addNewAuto(Auto a) {
        if (a.brand == null) {
            deliteNull();
        } else {
            autos.add(a);
        }
    }

    public static void setPlace(int a) {
        place = a;
    }

    public static int whiteAuto() {
        int count = 0;
        for (Auto a : autos) {
            if (a.colour == "White") {
                count++;
            }
        }
        return count;
    }

    public static int autoWithAutomat() {
        int caunt = 0;
        for (Auto a : autos) {
            if (a.isAutomat) caunt++;
        }
        return caunt;
    }

    public static void sameBrandAndColour() {

        for (Auto a : autos) {
            int caunt = 0;
            for (Auto b : autos) {
                if (a.brand.equals(b.brand) && a.colour.equals(b.colour)) {
                    caunt++;
                }
            }
            if (caunt > 1) System.out.println("Авто " + a.toString() + " имеют аналогичные себе по марке и цвету " +
                    (caunt) + " шт");
        }
    }

    public static void sameAuto() {
        for (Auto a : autos) {
            int caunt = 0;
            for (Auto b : autos) {
                if (a.hashCode() == b.hashCode()) {
                    caunt++;
                }
            }
            if (caunt > 1) System.out.println("Одинаковые авто: " + a.toString() + " имеют аналогичные себе" +
                    (caunt) + " шт");

        }
    }

    public static void sortAutoWithBrand() {
        autos.sort(Auto::compareTo);
    }
}