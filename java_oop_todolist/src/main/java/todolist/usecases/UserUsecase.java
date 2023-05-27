package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.UserEntity;
import todolist.models.UserModel;
import todolist.utils.DBConnectionUtil;

public class UserUsecase {
    private HikariDataSource dataSource;
    private UserModel model;

    public UserUsecase () {
        dataSource = DBConnectionUtil.getDataSource();
        model = new UserModel(dataSource);
    }

    public void AddUser(String userid, String password) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
        userData.setPassword(password);

        model.CreateUser(userData);

        System.out.println("Create user succeed!");
    }
 }
