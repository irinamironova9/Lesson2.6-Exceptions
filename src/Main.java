import transport.*;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws WrongLoginException,
            WrongPasswordException, FailedCheckupException {

        System.out.println(Data.isCorrect("login_4", "pass_02", "pass_02"));
//        System.out.println(Data.isCorrect("login_4", "pass_02", "pass_03"));


        Car lada = new Car("Lada", "Grande",1.7,
                Car.BodyType.SEDAN);
        Car audi = new Car("Audi", "A8 50 L TDI quattro",3.0,
                "   ");
        Car bmw = new Car("BMW", "Z8",3.0,
                "ПИКАП");
        Car kia = new Car("KIA", "Sportage 4",2.4,
                Car.BodyType.VAN);

        Truck volvo = new Truck("Volvo", "FH16", 7.0,
                Truck.LoadCapacityType.N1);
        Truck gaz = new Truck("ГАЗ", "3307", 8.0,
                Truck.LoadCapacityType.N2);
        Truck kamaz = new Truck("КАМАЗ", "65115", 6.5,
                null);
        Truck iveco = new Truck("Iveco", "S-Way", 9.4,
                Truck.LoadCapacityType.N3);

        Bus bus1 = new Bus("JHF", "B-43", 6.0,
                Bus.CapacityType.LARGE);
        Bus bus2 = new Bus("VLJHF", "hf 321", 6.3,
                Bus.CapacityType.SMALL);
        Bus bus3 = new Bus("Toyota", "Bus-157", 6.5,
                null);
        Bus bus4 = new Bus("PAZ", "3205", 6.5,
                Bus.CapacityType.VERY_LARGE);

        bus1.doCheckup();
        kia.doCheckup();
        iveco.doCheckup();

        doCheckupForAll(lada, audi, bmw, kia,
                volvo, gaz, kamaz, iveco,
                bus1, bus2, bus3, bus4);
    }

    public static void doCheckupForAll(Transport... vehicles)
            throws FailedCheckupException {

        try {
            for (Transport transport : vehicles) {
                transport.doCheckup();
            }
        } catch (FailedCheckupException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Диагностика прекращена.");
        }
    }
}