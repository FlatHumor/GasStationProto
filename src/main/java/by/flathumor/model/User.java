package by.flathumor.model;

public class User
{
    private Long id;
    private String username;
    private String realName;
    private String identificator;
    private String password;

    public Long getId() {
        return id;
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
