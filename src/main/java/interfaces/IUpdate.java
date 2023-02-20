package interfaces;

import java.io.IOException;

public interface IUpdate {

    void updateRecord(int user_id, String updated_name, String updated_email, String updated_password) throws IOException;
}
