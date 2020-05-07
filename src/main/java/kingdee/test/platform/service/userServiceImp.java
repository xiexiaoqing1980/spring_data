package kingdee.test.platform.service;

import kingdee.test.platform.dao.userMapper;
import kingdee.test.platform.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames="userCache")
public class userServiceImp implements userService {

    @Autowired
    userMapper userMapper;
    @Override
//    @Cacheable(key="#p0")
    public user findUserById(Integer id) {
        System.out.println("走数据库查询");
        return  userMapper.findUserById(id);

    }

    @Override
//    @Cacheable(keyGenerator = "keyGenerator") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public List<user> findUsers() {
        System.out.println("缓存中没有数据，要从数据库中查");
        List<user> users=userMapper.findUsers();
        return  users;

    }

    @Override
//    @CachePut 是先执行方法，然后把返回值保存或更新到缓存中
//    @CachePut(key = "#p.id")  //保证方法被调用，又希望结果被缓存。与@Cacheable区别在于是否每次都调用方法，常用于更新

    public void adduser(user user) {
         userMapper.adduser(user);
    }

    @Override
//    @CacheEvict(key ="#id")
    public void deleteUser(Integer id) {
        userMapper.deleteuser(id);

    }
}
