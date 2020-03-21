package com.loneliness.service;

import com.loneliness.entity.Phone;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;
@Local
public interface IPhoneService {
    public List<Phone> getAll();

    public void add(Phone phone);

    public void delete(String category,String model);

    public Phone get( int id);

    public List<Phone> getPhonesByStatusAndPrice(boolean status, BigDecimal price);

    public void edit(Phone phone);
}
