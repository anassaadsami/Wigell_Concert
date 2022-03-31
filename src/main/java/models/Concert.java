package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "concert")
public class Concert {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "concert_id")
    private int concertId;
    @Basic
    @Column(name = "artist_name")
    private String artistName;
    @Basic
    @Column(name = "concert_date")
    private LocalDate concertDate;
    @Basic
    @Column(name = "ticket_price")
    private double ticketPrice;
    @Basic
    @Column(name = "arena_id")
    private int arenaId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(LocalDate concertDate) {
        this.concertDate = concertDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }
    // method to add customer to List
    public  void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return concertId == concert.concertId && arenaId == concert.arenaId && Objects.equals(artistName, concert.artistName) && Objects.equals(concertDate, concert.concertDate) && Objects.equals(ticketPrice, concert.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertId, artistName, concertDate, ticketPrice, arenaId);
    }

    @Override
    public String toString() {
        return "Concert{" +
                "concertId=" + concertId +
                ", artistName='" + artistName + '\'' +
                ", concertDate=" + concertDate +
                ", ticketPrice=" + ticketPrice +
                ", arenaId=" + arenaId +
                ", customers=" + customers +
                '}';
    }
}
