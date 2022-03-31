package dao;

import models.Concert;
import models.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ConcertDao {

    public void addConcert(Object object) {
        Data data = new Data();
        data.addData(object);
    }

    // method to add customer to concert List
    public void addCustomerToConcert(Scanner input) {
        CustomerDao customerDao = new CustomerDao();
        Concert concert = getConcert(input);                  // get concert from db
        Customer customer = customerDao.getCustomer(input);    // get customer from db
        Collection<Customer> list = concert.getCustomers();  // get the customer list in concert module
        list.add(customer);
        concert.setCustomers(list);
        Data data = new Data();
        data.editData(Concert.class, concert);

    }

    public Concert getConcert(Scanner input) {
        System.out.print("enter concert Id you want to get:");
        int id = input.nextInt();
        Data data = new Data();
        return (Concert) data.getData(Concert.class, id);
    }

    public Collection<Concert> getAllConcerts() {
        Data data = new Data();
        Collection<Object> dataList = data.getDataList(Concert.class);
        Collection<Concert> outputList = new ArrayList<>();
        for (Object o : dataList) {
            outputList.add((Concert) o);
        }
        return outputList;
    }

    public void printAllConcerts(Collection<Concert> concerts) {
        for (Concert con : getAllConcerts()) {
            System.out.println(con);

        }
    }


    public void deleteConcert(Scanner input) {
        System.out.print("enter concert Id you want to delete:");
        int id = input.nextInt();
        Data data = new Data();
        data.deleteData(Concert.class, id);
    }

    /*public void editConcert(int id, Object[] objectDat) {
        //0-artistName 1-concertDate 2- ticketPrice 3-arenaId
        Data data = new Data();
        Concert consert = (Concert) data.getData(Concert.class, id);
        // use objectData array

        Data data2 = new Data();
        data2.editData(Concert.class, consert);
    }*/

    /* public void editConcert(Concert concert) {
         Data data = new Data();
         data.editData(Concert.class, concert);
     }*/
    public void editConcert(Scanner input) {
        //0-artistName 1-concertDate 2- ticketPrice 3-arenaId
        System.out.print("enter concert Id you want to edit:");
        ;
        int id = input.nextInt();
        Data data = new Data();
        Concert concert = (Concert) data.getData(Concert.class, id);

        System.out.print("enter artist name:");
        String name = input.next();
        concert.setArtistName(name);

        System.out.println("enter concert date year : mount : day:");
        int year = input.nextInt();
        int mounth = input.nextInt();
        int day = input.nextInt();
        concert.setConcertDate(LocalDate.of(year, mounth, day));

        System.out.print("enter ticket price:");
        double price = input.nextDouble();
        concert.setTicketPrice(price);

        System.out.print("enter arena Id:");
        int arenaId = input.nextInt();
        concert.setArenaId(arenaId);

        Data data2 = new Data();
        data2.editData(Concert.class, concert);
    }

    public void insertConcert(Scanner input) {
        Concert concert = new Concert();
        System.out.print("enter artist name:");
        String name = input.next();
        concert.setArtistName(name);

        System.out.println("enter concert date year : mount : day:");
        int year = input.nextInt();
        int mounth = input.nextInt();
        int day = input.nextInt();
        concert.setConcertDate(LocalDate.of(year, mounth, day));

        System.out.print("enter ticket price:");
        double price = input.nextDouble();
        concert.setTicketPrice(price);

        System.out.print("enter arena Id:");
        int arenaId = input.nextInt();
        concert.setArenaId(arenaId);
        addConcert(concert);
    }

    // by this method we add customers to a concert
    public void buyConcertTicket(Scanner input) {
        Data data = new Data();
        CustomerDao customerDao = new CustomerDao();
        Concert concert = new Concert();
        Customer customer = new Customer();
        System.out.println("welcome to CONCERT ONLINE , choose option:");
        System.out.println("1- your name on customer list");
        System.out.println("2- new customer");

        int choice = input.nextInt();
        boolean flag = false;
        if (choice == 1) {
            System.out.print("enter your first name:");
            String name = input.next();
            for (Customer cust : customerDao.getAllCustomers()) {
                if (cust.getFirstName().equals(name)) {
                    customer = cust;
                    flag = true;

                }
            }
            if (flag) {
                System.out.printf("welcome %s your on list.%n", name);
                System.out.println("we have these concerts:");
                Collection<Concert> x = getAllConcerts();
                printAllConcerts(x);
                System.out.print("select your favorite singer name:");
                String favorite = input.next();

                for (Concert con : x) {
                    if (con.getArtistName().equals(favorite)) {
                        concert = con;
                        concert.getCustomers().add(customer);
                        concert.setCustomers(concert.getCustomers());
                        data.editData(Concert.class, concert);


                        System.out.println("thanks, your ticket sent to this tel " + customer.getPhoneNumber());


                           /* CustomerDao customerDao = new CustomerDao();
                            Concert concert = getConcert(input);
                            Customer customer = customerDao.getCustomer(input);
                            Collection<Customer> list = concert.getCustomers();
                            list.add(customer);
                            concert.setCustomers(list);
                            Data data = new Data();
                            data.editData(Concert.class, concert);*/

                    }

                }

            } else {
                System.out.println("sorry your name is not on list");
            }

        } else if (choice == 2) {
            System.out.println("sorry the concert is full ");
        }

    }

}