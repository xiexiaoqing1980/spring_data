package kingdee.test.platform.service;

import kingdee.test.platform.pojo.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);
    List<user> findUsers();
    void adduser(user user);
    void deleteUser(Integer id);

}
