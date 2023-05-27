package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

import todolist.entities.UserEntity;

public class UserModel {

    private DataSource dataSource;

    public UserModel (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void CreateUser (UserEntity user) {
        String sql = "INSERT INTO user VALUES (?, ?, now())";

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        } 
    }

    public void ChangePassword (UserEntity user) {
        String sql = "UPDATE user SET password = ? WHERE userid = ?";

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getUserid());
            stmt.executeUpdate();
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }

    public UserEntity[] FindAllUser() {
        String sql = "SELECT * FROM user";

        try (
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)
        ) {

            List<UserEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setUserid(resultSet.getString("userid"));

                list.add(user);
            }

            return list.toArray(new UserEntity[]{});
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
}
