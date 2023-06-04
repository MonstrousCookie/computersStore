package com.kolokolnin.computersStore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputersStoreApplicationTests {
    //TODO: Тест на поднятие контекста это конечно хорошо, но не достаточно.
    // 1) Тебе нужно написать unit-тесты на все контракты сервиса ProductPropertiesService (не забыть сделать mock БД):
    //    List<E> allProducts();
    //    boolean createProduct(E pc);
    //    E readById(Long id);
    //    E readBySerialNumber(Long serialNumber);
    //    List<E> readByManufacturer(String manufacture);
    //    List<E> readByPrice(Long price);
    //    List<E> readByUnitsInStock(Long unitsInStock);
    //    boolean updateBySerialNumber(E laptop);
    // 2) Поскольку есть интеграция с БД, то также можно написать интеграционные тесты (это в принципе необязательно сейчас)
    @Test
    void contextLoads() {
    }

}
