package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.ProductProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface ProductPropertiesController<E extends ProductProperties> {
    //TODO: не очень хороший контракт, обычно используют пагинацию, т.к. сущностей может быть миллион
    @GetMapping("/all")
    @ResponseBody
    List<E> getAllProducts();

    //TODO: почему POST запрос ? Свойства продукта должно передавать именно в теле запроса ?
    // requestedProduct не очень хорошее название для такого кейса, может быть productByPropertyRequest ?
    @PostMapping("/all")
    @ResponseBody
    List<E> getProductsByProperty(@RequestBody E requestedProduct);

    //TODO: лучше переименовать requestedProduct в createProductRequest или addProductRequest
    @PostMapping("/add")
    @ResponseBody
    boolean addProduct(@RequestBody E requestedProduct);

    //TODO: почему здесь POST запрос ?
    // обычно API такое (id товара можно передавать в строке запроса, это не что-то секретное):
    // GET find/{{id}}
    // А ещё лучше будет GET api/v1/product/{{id}}
    @PostMapping("/find")
    @ResponseBody
    E getProductBySerialNumberOrId(@RequestBody E requestedProduct);

    //TODO: не очень хорошее API
    // обычно API такое (передаём id в строке запроса):
    // POST api/v1/product/update/{{id}} или POST api/v1/product/{{id}}/update
    @PostMapping("/update")
    @ResponseBody
    boolean setProduct(@RequestBody E requestedProduct);
}
