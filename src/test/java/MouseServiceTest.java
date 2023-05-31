import com.company.domain.Mouse;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.MouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MouseServiceTest {

    private final MouseService service = new MouseService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Mouse>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Mouse>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Mouse>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByWireLessTest() {
        String wireless = "yes";
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.findByWireLess(wireless);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by color method is not passed!");
    }
}
