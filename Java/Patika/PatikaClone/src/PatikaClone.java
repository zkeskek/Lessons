import Controllers.LoginController;
import Helpers.Helper;
import Helpers.Query;
import Views.LoginUI;

public class PatikaClone {
    public static void main(String[] args) {
        Helper.setLayout();

        Query query = new Query();

        LoginUI loginUI = new LoginUI(query, new LoginController(query));

    }
}
