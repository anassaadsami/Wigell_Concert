package dao;

import models.Address;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class AddressDao {

    public void addAddress(Object object) {
        Data data = new Data();
        data.addData(object);
    }

    public Address getAddress(Scanner input) {
        System.out.print("enter address Id you want to get:");;
        int id = input.nextInt();
        Data data = new Data();
        return (Address) data.getData(Address.class, id);
    }

    public Collection<Address> getAllAddresses() {
        Data data = new Data();
        Collection<Object> dataList = data.getDataList(Address.class);
        Collection<Address> outputList = new ArrayList<>();
        for (Object o : dataList) {
            outputList.add((Address) o);
        }
        return outputList;
    }
    public void printAllAddresses(Collection<Address> addresses){
        for (Address ad : getAllAddresses()){
            System.out.println(ad.toString());

        }
    }

    public void deleteAddress(Scanner input) {
        System.out.print("enter address Id you want to delete:");;
        int id = input.nextInt();
        Data data = new Data();
        data.deleteData(Address.class, id);
    }

   /* public void editAddress(int id, Object[] objectDat) {
        // 0-street 1-building# 2-zip 3-city
        Data data = new Data();
        Address address = (Address) data.getData(Address.class, id);
        address.setStreetName((String) objectDat[0]);
        address.setBuildingNumber((String) objectDat[1]);
        address.setZipCode((String) objectDat[2]);
        address.setCity((String) objectDat[3]);
        Data data2 = new Data();
        data2.editData(Address.class, address);
    }*/
    public void editAddress( Scanner input) {
        // 0-street 1-building# 2-zip 3-city
        System.out.print("enter address Id you want to edit:");;
        int id = input.nextInt();
        Data data = new Data();
        Address address = (Address) data.getData(Address.class, id);

        System.out.print("enter street name:");
        String street = input.next();
        address.setStreetName(street);

        System.out.print("enter building number:");
        String buildNo = input.next();
        address.setBuildingNumber(buildNo);

        System.out.print("enter zip code:");
        String zipCode = input.next();
        address.setZipCode(zipCode);

        System.out.print("enter city:");
        String city = input.next();
        address.setCity(city);

        Data data2 = new Data();
        data2.editData(Address.class, address);
    }

    public  void insertAddress(Scanner input){
        // 1 streetName 2 buildingNumber 3 zipCode 4 city
        Address address = new Address();
        System.out.print("enter street name:");
        String street = input.next();
        address.setStreetName(street);

        System.out.print("enter building number:");
        String buildNo = input.next();
        address.setBuildingNumber(buildNo);

        System.out.print("enter zip code:");
        String zipCode = input.next();
        address.setZipCode(zipCode);

        System.out.print("enter city:");
        String city = input.next();
        address.setCity(city);

        AddressDao addressDao = new AddressDao();
        addressDao.addAddress(address);

    }
}