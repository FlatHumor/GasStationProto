package by.flathumor.model;

public class Transaction
{
    private Long id;
    private User payer;
    private User recipient;
    private Double amount;
    private String description;
    private Long timestamp;

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
