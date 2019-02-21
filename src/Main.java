import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking(addAutoToList());
        Parking.deliteNull(); //удаление авто с прицепом и массой больше 3000
        parking.printAutoInParking(); //вывод списка авто на парковке
        Parking.deliteAuto(); //удаление авто с парковки
        Parking.addNewAuto(addAuto()); //добавление одного рандомного авто (если есть места).
    }

    public static Auto addAuto() {
        Random random = new Random();
        return new Auto(Auto.brands[random.nextInt(5)], Auto.colours[random.nextInt(5)],
                Auto.isAutomats[random.nextInt(2)], Auto.trailers[random.nextInt(4)],
                random.nextInt(3500));
    }

    public static ArrayList<Auto> addAutoToList() {
        ArrayList<Auto> autoList = new ArrayList<Auto>();
        for (int i = 0; i < 90; i++) {
            autoList.add(addAuto());
        }
        return autoList;
    }
}
