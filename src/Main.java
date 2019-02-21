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
        Parking.setPlace(place); //устанавливаем размер парковки
        Parking parking = new Parking(addAutoToList()); // создаём 30 рандомных авто на парковке
        Parking.deliteNull(); //удаление авто с прицепом и массой больше 3000
        parking.printAutoInParking(); //вывод списка авто на парковке
        Parking.deliteAuto(); //удаление авто с парковки
        Parking.addNewAuto(addAuto()); //добавление одного рандомного авто (если есть места).
        System.out.println("Количество белых авто на парковке " + Parking.whiteAuto());
        System.out.println("Количество авто с АКПП " + Parking.autoWithAutomat()); // вывод количества авто с автоматом
        Parking.sameBrandAndColour(); // вывод авто с одинаковой маркой и цветом
        Parking.sameAuto(); // одинаковые авто на парковке
        Parking.sortAutoWithBrand();
        parking.printAutoInParking(); //вывод списка авто на парковке

    }

    public static Auto addAuto() {
        Random random = new Random();
        return new Auto(Auto.brands[random.nextInt(5)], Auto.colours[random.nextInt(5)],
                Auto.isAutomats[random.nextInt(2)], Auto.trailers[random.nextInt(4)],
                random.nextInt(3500));
    }

    public static ArrayList<Auto> addAutoToList() {
        ArrayList<Auto> autoList = new ArrayList<Auto>();
        for (int i = 0; i < 30; i++) {
            autoList.add(addAuto());
        }
        return autoList;
    }
}
