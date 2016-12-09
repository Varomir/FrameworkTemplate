package ddt;

import org.testng.annotations.DataProvider;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "SearchTestData", parallel=false)
    public static Iterator<Object[]> createDataC0001() {
        List<Object[]> data = new ArrayList<Object[]>();

        data.add(new Object[] {"New York City", LocalDate.of(2016, 12, 20), LocalDate.of(2016, 12, 25)});
        data.add(new Object[] {"Los Angeles", LocalDate.of(2016, 12, 22), LocalDate.of(2016, 12, 28)});
        data.add(new Object[] {"Las Vegas, Nevada", LocalDate.of(2016, 12, 29), LocalDate.of(2017, 01, 03)});
        data.add(new Object[] {"Kiev", LocalDate.of(2016, 12, 31), LocalDate.of(2017, 01, 02)});
        data.add(new Object[] {"Paris", LocalDate.of(2016, 12, 31), LocalDate.of(2017, 01, 01)});

        return data.iterator();
    }
}
