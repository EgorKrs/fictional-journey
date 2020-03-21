package com.loneliness.service;

import com.loneliness.entity.Phone;
import com.loneliness.repository.IPhoneRepository;
import com.loneliness.repository.PhoneRepository;



import javax.ejb.*;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.util.List;
import java.util.Optional;





@Singleton
@Startup

public class PhoneService implements IPhoneService{


    IPhoneRepository iPhoneRepository = new PhoneRepository();

    public List<Phone> getAll(){
        return iPhoneRepository.getPhonesByIdIsNotNull();
    }

    public void add(Phone phone){
        iPhoneRepository.add(phone);
    }

    public void delete(String category,String model){
        iPhoneRepository.deleteByCategoryAndModel(category, model);
    }

    public Phone get( int id){
        return iPhoneRepository.findById(id);
    }

    public List<Phone> getPhonesByStatusAndPrice(boolean status, BigDecimal price){
        return iPhoneRepository.getPhonesByStatusAndPrice(status, price);
    }

    public void edit(Phone phone){
        Phone editPhone=get(phone.getId());
        editPhone.setCategory(phone.getCategory());
        editPhone.setModel(phone.getModel());
        editPhone.setPrice(phone.getPrice());
        editPhone.setStatus(phone.isStatus());
        iPhoneRepository.update(editPhone);
    }


}
