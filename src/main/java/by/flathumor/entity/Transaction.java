package by.flathumor.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transaction")
@NamedQueries(
        @NamedQuery(name = "Transaction.findAll", query = "select t from Transaction t"))
public class Transaction
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @JoinColumn(name="payer_id")
    @ManyToOne(targetEntity = User.class)
    private User payer;

    @JoinColumn(name="recipient_id")
    @ManyToOne(targetEntity = User.class)
    private User recipient;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "stamp")
    private Long timestamp;

    @ManyToMany(mappedBy = "transactions")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public User getPayer() {
        return payer;
    }

    public User getRecipient() {
        return recipient;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
