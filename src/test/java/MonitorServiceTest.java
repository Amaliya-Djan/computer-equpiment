import com.company.domain.Monitor;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.MonitorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MonitorServiceTest {
    private final MonitorService service = new MonitorService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Monitor>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Monitor>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Monitor>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void refreshRateTest() {
        Integer refreshRate = 19;
        ResponseEntity<DataDTO<List<Monitor>>> all = service.refreshRate(refreshRate);
        Assertions.assertTrue(all.getData().isSuccess(), "Find by refresh rate method is not passed!!");
    }

    @Test
    public void displaySizeTest() {
        Integer displaySize = 120;
        ResponseEntity<DataDTO<List<Monitor>>> all = service.displaySize(displaySize);
        Assertions.assertTrue(all.getData().isSuccess(), "Find by display size method is not passed!!");
    }
}
