package kingdee.test.platform.service;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class TestCaseServiceImp implements  TestCaseService {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<String> findAllReports() {
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );//建立连接
        DB get_db_credit = mongoClient.getDB("credit_2");//数据库名



        return null;
    }


    /**
     * 插入一条数据
     * @param info            存储对象
     * @param collectionName
     */
    @Override
    public void insertReport( Class info,String collectionName) {
        mongoTemplate.insert(info,collectionName);


    }
}
