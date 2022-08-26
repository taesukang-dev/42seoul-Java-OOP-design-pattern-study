package abstractfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

class UserInfo {
    private String userId;
    private String passwd;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

class Product {
    private String productId;
    private String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

abstract class DaoFactory {
    public abstract UserInfoDao createUserInfoDao();
    public abstract ProductDao createProductDao();
}

class MySqlDaoFactory extends DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMySqlDao();
    }
    @Override
    public ProductDao createProductDao() {
        return new ProductMySqlDao();
    }
}

class OracleDaoFactory extends DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }
    @Override
    public ProductDao createProductDao() {
        return new ProductOracleDao();
    }
}

abstract class UserInfoDao {
    public abstract void insertUserInfo(UserInfo user);
    public abstract void updateUserInfo(UserInfo user);
    public abstract void deleteUserInfo(UserInfo user);
}

class UserInfoMySqlDao extends UserInfoDao {

    @Override
    public void insertUserInfo(UserInfo user) {
        System.out.println("insert MySql info");
    }

    @Override
    public void updateUserInfo(UserInfo user) {
        System.out.println("update MySql info");
    }

    @Override
    public void deleteUserInfo(UserInfo user) {
        System.out.println("delete MySql info");
    }
}

class UserInfoOracleDao extends UserInfoDao {

    @Override
    public void insertUserInfo(UserInfo user) {
        System.out.println("insert oracle info");
    }

    @Override
    public void updateUserInfo(UserInfo user) {
        System.out.println("update oracle info");
    }

    @Override
    public void deleteUserInfo(UserInfo user) {
        System.out.println("delete oracle info");
    }
}

abstract class ProductDao {
    abstract public void insertProduct(Product product);
    abstract public void updateProduct(Product product);
    abstract public void deleteProduct(Product product);
}

class ProductMySqlDao extends ProductDao {

    @Override
    public void insertProduct(Product product) {
        System.out.println("insert MySql product");
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("update MySql product");
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("delete MySql product");
    }
}

class ProductOracleDao extends ProductDao {

    @Override
    public void insertProduct(Product product) {
        System.out.println("insert Oracle product");
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("update Oracle product");
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("delete Oracle product");
    }
}

public class AbstractFactoryImpl {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/gangtaesu/Desktop/42seoul-Java-OOP-design-pattern-study/week4/src/abstractfactory/db.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPasswd("!@#$%");
        userInfo.setUserName("Tomas");

        Product product = new Product();
        product.setProductId("0011AA");
        product.setProductName("TV");

        DaoFactory daoFactory = null;
        UserInfoDao userInfoDao = null;
        ProductDao productDao = null;

        if(dbType.equals("ORACLE")){
            daoFactory = new OracleDaoFactory();
        }
        else if(dbType.endsWith("MYSQL")){
            daoFactory = new MySqlDaoFactory();
        }
        else{
            System.out.println("db support error");
            return;
        }

        userInfoDao = daoFactory.createUserInfoDao();
        productDao = daoFactory.createProductDao();

        System.out.println("==USERINFO TRANSACTION==");
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

        System.out.println("==PRODUCT TRANSACTION==");
        productDao.insertProduct(product);
        productDao.updateProduct(product);
        productDao.deleteProduct(product);
    }
}
