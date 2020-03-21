package com.loneliness.repository;

import com.loneliness.entity.Phone;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IPhoneRepository {
    void add(Phone phone);
    Optional<Phone> findByPriceAndStatus(BigDecimal price,boolean status);
    void deletePhoneByCategoryAndModel(String category, String model);
    void deleteByCategoryAndModel(String category, String model);
    List<Phone> getPhonesByStatusAndPrice(boolean status, BigDecimal price);
    List<Phone> getPhonesByIdIsNotNull();
    Phone findById(int id);
    void update(Phone phone);

}
