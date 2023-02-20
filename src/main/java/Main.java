import entity.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OrdersReader;
import service.UsersReader;

import java.io.IOException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String [] args) throws IOException {
        UsersReader ureader = new UsersReader();
        OrdersReader or = new OrdersReader();
        ureader.readUserById(1);
        ureader.insert("Michael Norton", "micky@hmail.com","123" );
        ureader.readAllUsers();
        //ureader.updateRecord(6, "Michael Podolyaka", "podolyaka@hmail.com", "456");
        ureader.delete(8);
        ureader.readAllUsers();


        or.readOrderById(1);
        or.readOrderByUserId(1);





    }
}
