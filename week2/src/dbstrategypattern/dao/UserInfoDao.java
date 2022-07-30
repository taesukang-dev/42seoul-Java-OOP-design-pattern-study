package dbstrategypattern.dao;

public interface UserInfoDao {
    public void insert(String userName);

    public void update(String userName);

    public void delete(String userName);
}
