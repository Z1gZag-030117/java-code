package com.zz;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Boy {

    @Autowired
    private Pet[] pet;
    @Autowired
    private AddressDao address;

//    public Boy(Pet pet) {
//        this.pet = pet;
//    }


//    @Autowired
//    public Boy(Pet pet, AddressDao address) {
//        this.pet = pet;
//        this.address = address;
//    }
//
//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }
//
//    public AddressDao getAddress() {
//        return address;
//    }
//
//    public void setAddress(AddressDao address) {
//        this.address = address;
//    }

    @Override
    public String toString() {

        for (Pet pet1 : pet) {
            System.out.println(pet1);
        }

        return "Boy{" +
                "pet=" + pet +
                ", address=" + address +
                '}';
    }
}
