package dao;

import java.util.*;

import model.Funcionario;

import java.sql.*;

public class FuncionarioDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/tp01?useTimezone=true&serverTimezone=America/Sao_Paulo";
            String dbUsername = "root";
            String dbPassword = "aula";

            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Funcionario e) {
        int status = 0;
        try {
            Connection con = FuncionarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO user905(name, password, email, country) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Funcionario e) {
        int status = 0;
        try {
            Connection con = FuncionarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE user905 SET name=?, password=?, email=?, country=? WHERE id=?"
            );
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = FuncionarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user905 WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Funcionario getEmployeeById(int id) {
        Funcionario e = new Funcionario();
        try {
            Connection con = FuncionarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905 WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static List<Funcionario> getAllEmployees() {
        List<Funcionario> list = new ArrayList<Funcionario>();
        try {
            Connection con = FuncionarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario e = new Funcionario();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}