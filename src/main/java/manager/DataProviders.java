package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataFile() throws IOException {
        List <Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();

        while(line !=null){
            String[] splip = line.split(",");
            list.add( new Object[]{new User().withEmail(splip[0]).withPassword(splip[1])});
            line = reader.readLine();
        }
        return  list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataCarFile() throws IOException {
        List <Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/car.csv")));
        String line = reader.readLine();

        while(line !=null){
            String[] splip = line.split(",");
            list.add( new Object[]{new Car()
                    .withLocation(splip[0])
                    .withMake(splip[1])
                    .withModel(splip[2])
                    .withYear(splip[3])
                    .withEngine(splip[4])
                    .withFuel(splip[5])
                    .withGear(splip[6])
                    .withWd(splip[7])
                    .withDoors(splip[8])
                    .withSeats(splip[9])
                    .withCarClass(splip[10])
                    .withFuelConsumption(splip[11])
                    .withCarRegNum(splip[12])
                    .withPrice(splip[13])
                    .withDistanceIncluded(splip[14])

            });
            line = reader.readLine();
        }
        return  list.iterator();
    }

}
