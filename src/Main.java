import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(addAutoToList());
        parking.printAutoInParking();
    }


    public static Auto addAuto() {
        Random random = new Random();
        return new Auto(Auto.brands[random.nextInt(5)], Auto.colours[random.nextInt(5)],
                Auto.transmissions[random.nextInt(2)], Auto.trailers[random.nextInt(4)],
                random.nextInt(3500));
    }

    public static ArrayList<Auto> addAutoToList (){
        ArrayList autoList = new ArrayList();
        for (int i = 0; i < 60; i++){
            autoList.add(addAuto());
        }
        return autoList;
    }




}
