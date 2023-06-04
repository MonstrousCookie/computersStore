package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.ProductProperties;

import java.util.List;

//TODO: А может посмотреть в сторону другого решения ?
// Почему у тебя сервис, который называется ProductPropertiesService имеет контракты, не имеющие
// никакого отношения к свойствам продукта:
// List<E> allProducts();
// boolean createProduct(E pc);
// P.S. Лично мне кажется, что можно выделить эти контракты в отдельный интерфейс(-ы).
public interface ProductPropertiesService<E extends ProductProperties> {
    List<E> allProducts();

    boolean createProduct(E pc);

    //TODO: read не очень хороший глагол для такого метода
    // Лучше использовать get
    E readById(Long id);

    //TODO: переименовать
    E readBySerialNumber(Long serialNumber);

    //TODO: переименовать
    List<E> readByManufacturer(String manufacture);

    //TODO: переименовать
    List<E> readByPrice(Long price);

    //TODO: переименовать
    List<E> readByUnitsInStock(Long unitsInStock);

    boolean updateBySerialNumber(E laptop);
}
