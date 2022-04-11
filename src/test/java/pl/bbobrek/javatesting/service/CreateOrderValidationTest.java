package pl.bbobrek.javatesting.service;


import org.junit.jupiter.api.Test;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderValidationTest {

    @Test
    public void shouldReturnFalseIfCreateOrderDtoListOfProductsIsEmpty(){

        //given
/*        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setId(1);
        productDto.setQuantity(5);

        CreateOrderDto.ProductDto productDto1 = new CreateOrderDto.ProductDto();
        productDto1.setId(2);
        productDto1.setQuantity(4);*/

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        createOrderDto.setProducts(productDtos);

        //when
        boolean result = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

        //then
        assertFalse(result);

    }

    @Test
    public void shouldReturnFalseIfCreateOrderDtoListOfProductsIsNull(){

        //given

        CreateOrderDto createOrderDto = new CreateOrderDto();
        createOrderDto.setProducts(null);

        //when
        boolean result = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

        //then
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfAnyIdOfProductDtoIsZero(){

        //given
        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setId(1);
        productDto.setQuantity(5);

        CreateOrderDto.ProductDto productDto1 = new CreateOrderDto.ProductDto();
        productDto1.setId(2);
        productDto1.setQuantity(4);

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        createOrderDto.setProducts(productDtos);


        //when
        boolean result = productDtos.
                stream().anyMatch(i -> i.getId() == 0);

        //then
        assertFalse(result);
    }

}