package kingdee.test.platform.service;

import java.util.List;

public interface TestCaseService {

    public List<String> findAllReports();

    public void insertReport(Class info,String collectionName);

}
