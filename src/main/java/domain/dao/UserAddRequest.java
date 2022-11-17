package domain.dao;


import domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddRequest {

    private String userName;
    private String password;

    public User toEntity() {
        return new User(userName,password);
    }
}
