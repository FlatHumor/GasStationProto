package by.flathumor.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "external_id")
    private String externalId;

    @JoinColumn(name = "order_id")
    @ManyToOne(targetEntity = Order.class)
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
