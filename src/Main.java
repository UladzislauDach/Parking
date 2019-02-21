import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество мест на парковке (от 5 до 50) ");
        int place = sc.nextInt();
        while (place < 5 || place > 50) {
            System.out.println("Incorrect value. Plz, try again");
            place = sc.nextInt();
        }
        Parking.setPlace(place); //устанавливаем размер парковки++

        System.out.println("Введите 1 что бы заполнить паркинг 30ю рандомными авто \n");

        int chose = 1;
        while (chose > 0 && chose < 10) {
            chose = sc.nextInt();
            switch (chose) {


                case 1:
                    Parking parking = new Parking(addAutoToList()); //создаём паркинг и туда передаём лист авто++
                    Parking.deliteNull(); //удаление авто с прицепом и массой больше 3000 ???
                    break;
                case 2:
                    printAutoInParking(Parking.getAutos()); //вывод списка авто на парковке++
                    break;
                case 3:
                    Parking.setAutos(deliteAuto(Parking.getAutos())); //удаление рандомного авто с парковки и изменение листа Паркинга ++
                    break;
                case 4:
                    Parking.setAutos(addNewAuto(addAuto(), Parking.getAutos())); //добавление одного рандомного авто (если есть места). ++
                    break;
                case 5:
                    System.out.println("Количество белых авто на парковке " + whiteAuto(Parking.getAutos())); // вывод количества белых авто ++
                    break;
                case 6:
                    System.out.println("Количество авто с АКПП " + autoWithAutomat(Parking.getAutos())); // вывод количества авто с автоматом
                    break;
                case 7:
                    sameBrandAndColour(Parking.getAutos()); // вывод авто с одинаковой маркой и цветом ++
                    break;
                case 8:
                    sameAuto(Parking.getAutos()); // вывод абсолютно одинаковых авто на парковке (хешкод) ++
                    break;
                case 9:
                    Parking.setAutos(sortAutoWithBrand(Parking.getAutos())); //сортировка листа с его изменением ++
                default:
                    break;
            }
        }
    }

    private static Auto addAuto() {  //создаём один авто с рандомными полями
        Random random = new Random();
        return new Auto(Auto.brands[random.nextInt(5)], Auto.colours[random.nextInt(5)],
                Auto.isAutomats[random.nextInt(2)], Auto.trailers[random.nextInt(4)],
                random.nextInt(3500));
    }

    private static ArrayList<Auto> addAutoToList() { //помещаем 30 рандомных авто в лист, ретурним лист
        ArrayList<Auto> autoList = new ArrayList<Auto>();
        for (int i = 0; i < 30; i++) {
            autoList.add(addAuto());
        }
        return autoList;
    }

    private static void printAutoInParking(ArrayList<Auto> autos) {
        for (Auto a : autos) {
            System.out.println(a.toString());
        }
    }

    private static ArrayList<Auto> deliteAuto(ArrayList<Auto> autos) {
        Random random = new Random();
        int i = random.nextInt(autos.size());
        System.out.println("Авто " + autos.get(i).toString() + " уехал с парковки. Свободных мест "
                + (Parking.getPlace()+1));
        autos.remove(i);
        Parking.setPlace(Parking.getPlace()+1);
        return autos;
    }

    private static ArrayList<Auto> addNewAuto(Auto a, ArrayList<Auto> autos) {
        if (a.brand == null) {
            Parking.deliteNull();
        } else {
            autos.add(a);
        }
        return autos;
    }

    private static int whiteAuto(ArrayList<Auto> autos) {
        int count = 0;
        for (Auto a : autos) {
            if (a.colour == "White") {
                count++;
            }
        }
        return count;
    }

    private static int autoWithAutomat(ArrayList<Auto> autos) {
        int caunt = 0;
        for (Auto a : autos) {
            if (a.isAutomat) caunt++;
        }
        return caunt;
    }

    private static void sameBrandAndColour(ArrayList<Auto> autos) {
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

    private static void sameAuto(ArrayList<Auto> autos) {
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

    private static ArrayList<Auto> sortAutoWithBrand(ArrayList<Auto> autos) {
        autos.sort(Auto::compareTo);
        return autos;
    }
}