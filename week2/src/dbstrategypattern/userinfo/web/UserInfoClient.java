package dbstrategypattern.userinfo.web;

import dbstrategypattern.UserInfo;
import dbstrategypattern.dao.UserInfoDao;
import dbstrategypattern.dao.mysql.UserInfoMySqlDao;
import dbstrategypattern.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) {
        UserInfo kim = new UserInfo();
        UserInfoDao dao;
        kim.setUserId("12345");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("/Users/gangtaesu/Desktop/42seoul-Java-OOP-design-pattern-study/week2/src/dbstrategypattern/userinfo/web/db.properties"));
            String dbType = prop.getProperty("DBTYPE");
            if (dbType.equals("MYSQL")){
                dao = new UserInfoMySqlDao();
                dao.insert(kim.getUserName());
                dao.update(kim.getUserName());
                dao.delete(kim.getUserName());
            } else {
                dao = new UserInfoOracleDao();
                dao.insert(kim.getUserName());
                dao.update(kim.getUserName());
                dao.delete(kim.getUserName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
