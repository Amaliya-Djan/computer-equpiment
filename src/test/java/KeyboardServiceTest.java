import com.company.domain.Keyboard;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.KeyboardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KeyboardServiceTest {

    private final KeyboardService service = new KeyboardService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Keyboard>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Keyboard>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Keyboard>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Keyboard>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByWidthAndHeightTest() {
        Double width = 22D;
        Double height = 11D;
        ResponseEntity<DataDTO<List<Keyboard>>> all = service.findByWidthAndHeight(width, height);
        Assertions.assertTrue(all.getData().isSuccess(), "Find by width and height method is not passed!!");
    }
}
