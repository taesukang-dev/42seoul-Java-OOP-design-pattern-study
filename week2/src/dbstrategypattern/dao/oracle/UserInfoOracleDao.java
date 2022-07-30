package dbstrategypattern.dao.oracle;

import dbstrategypattern.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {

    private String dbType = "ORACLE";
    @Override
    public void insert(String userName) {
        System.out.println("insert into " + dbType + " DB userName = " + userName);
    }

    @Override
    public void update(String userName) {
        System.out.println("update into " + dbType + " DB userName = " + userName);
    }

    @Override
    public void delete(String userName) {
        System.out.println("delete into " + dbType + " DB userName = " + userName);
    }
}
