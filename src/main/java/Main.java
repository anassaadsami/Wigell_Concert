import dao.AddressDao;
import dao.ArenaDao;
import dao.ConcertDao;
import dao.CustomerDao;
import models.Address;
import models.Arena;
import models.Concert;
import models.Customer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AddressDao addressDao = new AddressDao();
        // addressDao.insertAddress(input);
        //addressDao.editAddress(input);
        // addressDao.deleteAddress(input);
        //System.out.println(addressDao.getAddress(input));
        // addressDao.printAllAddresses(addressDao.getAllAddresses());

        CustomerDao customerDao = new CustomerDao();

        //customerDao.insertCustomer(input);
        //System.out.println(customerDao.getCustomer(input));
        //System.out.println(customerDao.getCustomer(input).getFirstName());
        //customerDao.printAllCustomer(customerDao.getAllCustomers());
        //System.out.println(customerDao.getCustomer(input));
        //customerDao.deleteCustomer(input);
        //customerDao.editCustomer(input);

        ConcertDao concertDao = new ConcertDao();
        // this method to add customer to customerList in concert object
        //concertDao.addCustomerToConcert(input);

        //concertDao.buyConcertTicket(input);

        //concertDao.insertConcert(input);
        System.out.println(concertDao.getConcert(input));
        //System.out.println(concertDao.getConcert(input).getCustomers().isEmpty());   //----> false
        //System.out.println(concertDao.getConcert(input).getCustomers());

        Collection<Customer> x = concertDao.getConcert(input).getCustomers();
        for (Customer cust : x
             ) {
            System.out.println(cust);
        }
        //concertDao.printAllConcerts(concertDao.getAllConcerts());
        //concertDao.deleteConcert(input);
        // concertDao.editConcert(input);

        ArenaDao arenaDao = new ArenaDao();
        //arenaDao.insertArena(input);
        //arenaDao.deleteArena(input);
        //System.out.println(arenaDao.getArena(input));
        //arenaDao.printAllArenas(arenaDao.getAllArenas());
        // arenaDao.editArena(input);

        input.close();

    }

   /* public static void printAllItems(Collection<Object> x) {
        for (Object obj : x) {
            System.out.println(obj);

        }

    }*/

}
