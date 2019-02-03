package by.flathumor.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
//@NamedQueries({
//        @NamedQuery(name = "User.findAll", query = "select u from User u"),
//        @NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = :username")})
public class User
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "ident")
    private String identificator;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_transaction_rel",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"))
    private Set<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getIdentificator() {
        return identificator;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
