package dao;

import models.Address;
import models.Concert;
import models.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CustomerDao {

    public void addCustomer(Object object) {
        Data data = new Data();
        data.addData(object);
    }

    public Customer getCustomer(Scanner input) {
        System.out.print("enter customer Id you want to get:");
        int id = input.nextInt();
        Data data = new Data();
        return (Customer) data.getData(Customer.class, id);
    }

    // method to add concert to customer List
    /*public void addConcertToCustomer(Scanner input){
         Data data = new Data();
         ConcertDao concertDao = new ConcertDao();
         Concert con = concertDao.getConcert(input);
         Customer customer = getCustomer(input);
         Collection<Concert> list = customer.getConcerts();
         list.add(con);
         customer.setConcerts(list);
         Data data2 = new Data();
         data2.editData(Customer.class, customer);

    }*/


    public Collection<Customer> getAllCustomers() {
        Data data = new Data();
        Collection<Object> dataList = data.getDataList(Customer.class);
        Collection<Customer> outputList = new ArrayList<>();
        for (Object o : dataList) {
            outputList.add((Customer) o);
        }
        return outputList;
    }
    public void printAllCustomer(Collection<Customer> customers){
        for (Customer cust: getAllCustomers()){
            System.out.println(cust);

        }
    }

    public void deleteCustomer(Scanner input) {
        System.out.print("enter customer Id you want to delete:");
        int id = input.nextInt();
        Data data = new Data();
        data.deleteData(Customer.class, id);
    }

   /* public void editCustomer(int id, Object[] objectDat) {
        //0-firstName 1-lastName 2-dob 3- phone 4-addressId
        Data data = new Data();
        Customer customer = (Customer) data.getData(Customer.class, id);
        // use objectData array
        customer.setFirstName((String) objectDat[0]);
        customer.setLastName((String) objectDat[1]);
        customer.setDob((LocalDate) objectDat[2]);
        customer.setPhoneNumber((String) objectDat[3]);
        customer.setAddressId((Integer) objectDat[4]);
        Data data2 = new Data();
        data2.editData(Customer.class, customer);
    }*/

    public void editCustomer( Scanner input) {
        //0-firstName 1-lastName 2-dob 3- phone 4-addressId
        System.out.print("enter customer Id you want to edit:");;
        int id = input.nextInt();
        Data data = new Data();
        Customer customer = (Customer) data.getData(Customer.class, id);
        // insertCustomer(input);  // how to change it to return customer ??

        System.out.print("enter customer first name:");
        String fname = input.next();
        customer.setFirstName(fname);

        System.out.print("enter customer last name:");
        String lname = input.next();
        customer.setLastName(lname);

        System.out.println("enter customer birthday year : mount : day:");
        int year = input.nextInt();
        int mounth = input.nextInt();
        int day = input.nextInt();
        customer.setDob(LocalDate.of(year,mounth,day));

        System.out.print("enter customer phone number:");
        String phone = input.next();
        customer.setPhoneNumber(phone);

        System.out.print("enter customer address Id:");
        int add = input.nextInt();
        customer.setAddressId(add);

        Data data2 = new Data();
        data2.editData(Customer.class, customer);
    }



   /* public void editCustomer(Customer customer) {
        //0-firstName 1-lastName 2-dob 3- phone 4-addressId
        Data data = new Data();
        data.editData(Customer.class, customer);
    }
*/
    public void insertCustomer(Scanner input){
        Customer customer = new Customer();
        System.out.print("enter customer first name:");
        String fname = input.next();
        customer.setFirstName(fname);

        System.out.print("enter customer last name:");
        String lname = input.next();
        customer.setLastName(lname);

        System.out.println("enter customer birthday year : mount : day:");
        int year = input.nextInt();
        int mounth = input.nextInt();
        int day = input.nextInt();
        customer.setDob(LocalDate.of(year,mounth,day));

        System.out.print("enter customer phone number:");
        String phone = input.next();
        customer.setPhoneNumber(phone);

        System.out.print("enter customer address Id:");
        int add = input.nextInt();
        customer.setAddressId(add);

        addCustomer(customer);
    }
}