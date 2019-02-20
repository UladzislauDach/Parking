import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(filterAutoAndAddToParking(addAutoArray()));
        System.out.println(parking.autoInParking.toString());
    }



    public static ArrayList<Auto> addAutoArray() {
        Random random = new Random();
        ArrayList<Auto> autoArray = new ArrayList<>();
        for (int i = 0; i < 60; i++) { //создаём 60 рандомных авто
            autoArray.add(new Auto(Auto.brands[random.nextInt(5)], Auto.colours[random.nextInt(5)],
                    Auto.transmissions[random.nextInt(2)], Auto.trailers[random.nextInt(4)],
                    random.nextInt(3500)));
        }
        return autoArray;
    }

    public static ArrayList<Auto> filterAutoAndAddToParking(ArrayList<Auto> autoArray) {
        ArrayList<Auto> flitradAutoList = new ArrayList<>();
        for (Auto auto : autoArray) {
            if (auto.trailer || auto.weight >= 3000) {
                System.out.println("Автомобиль " + auto.toString() + " не может посетить парковку т к имеет не " +
                        "подходящую массу имеет прицеп");

            }
            else {
                System.out.println("Автомобиль " + auto.toString() + " приехал на парковку. Свободных мест : ");
                flitradAutoList.add(auto);
            }
        }
        return flitradAutoList;

    }




}
