package pl.bbobrek.javatesting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
class OrderServiceTest {

    @Mock
    private OrderItemService orderItemService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCheckConvertingCreateOrderDtoToOrder(){

        //given
        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();

        //when

        //then

    }

}