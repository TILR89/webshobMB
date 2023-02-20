package entity;

import java.util.Objects;

public class Users {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_password;

    public Users (int user_id, String user_name, String user_email, String user_password){
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public Users ( String user_name, String user_email, String user_password){
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public Users() {
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return user_id == users.user_id && Objects.equals(user_name, users.user_name) && Objects.equals(user_email, users.user_email) && Objects.equals(user_password, users.user_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_name, user_email, user_password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }



}
