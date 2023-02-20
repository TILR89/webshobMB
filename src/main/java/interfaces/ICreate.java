package interfaces;

import java.io.IOException;

public interface ICreate {


    void insert(String user_name, String user_email, String user_password) throws IOException;
}
