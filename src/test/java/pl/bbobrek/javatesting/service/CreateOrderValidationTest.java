package pl.bbobrek.javatesting.service;


import org.junit.jupiter.api.Test;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderValidationTest {

    @Test
    public void shouldReturnTrueIfCreatedOrderDtoListOfProductsIsNotNullOrEmpty(){
        //given
        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setId(1);
        productDto.setQuantity(5);

        CreateOrderDto.ProductDto productDto1 = new CreateOrderDto.ProductDto();
        productDto1.setId(2);
        productDto1.setQuantity(4);

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        productDtos.add(productDto);
        productDtos.add(productDto1);
        createOrderDto.setProducts(productDtos);

        //when
        boolean result = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

        //then
        assertTrue(result);

    }

    @Test
    public void shouldReturnFalseIfCreateOrderDtoListOfProductsIsEmpty(){

        //given


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
        productDto1.setId(0);
        productDto1.setQuantity(4);

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        productDtos.add(productDto);
        productDtos.add(productDto1);
        createOrderDto.setProducts(productDtos);


        //when
        boolean result1 = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

/*        boolean result = productDtos.
                stream().allMatch(i -> i.getId() != 0);*/

        //then
        assertFalse(result1);
    }

    @Test
    public void shouldReturnFalseIfQuantityOfAnyProductDtoIsZero(){

        //given
        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setId(1);
        productDto.setQuantity(5);

        CreateOrderDto.ProductDto productDto1 = new CreateOrderDto.ProductDto();
        productDto1.setId(1);
        productDto1.setQuantity(0);

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        productDtos.add(productDto);
        productDtos.add(productDto1);
        createOrderDto.setProducts(productDtos);


        //when
/*        boolean result = productDtos.
                stream().allMatch(i -> i.getQuantity() != 0);*/

        boolean result1 = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

        //then
        assertFalse(result1);
    }

    @Test
    public void shouldReturnTrueIfAllCreateProductDtoMatchesValidation(){
        //given
        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setId(1);
        productDto.setQuantity(5);

        CreateOrderDto.ProductDto productDto1 = new CreateOrderDto.ProductDto();
        productDto1.setId(1);
        productDto1.setQuantity(2);

        CreateOrderDto createOrderDto = new CreateOrderDto();
        List<CreateOrderDto.ProductDto>productDtos = new ArrayList<>();
        productDtos.add(productDto);
        productDtos.add(productDto1);
        createOrderDto.setProducts(productDtos);


        //when

        boolean result1 = CreateOrderValidation.validateCreateOrderDto(createOrderDto);

/*        boolean result = productDtos.
                stream().allMatch(i -> i.getQuantity() != 0
                & i.getId() != 0);*/


        //then
        assertTrue(result1);
    }
}