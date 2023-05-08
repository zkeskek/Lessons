package Views;

import Controllers.*;
import Helpers.Constant;
import Helpers.Helper;
import Helpers.Query;
import Models.User;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUI extends JFrame{

    private final Query query;
    private final LoginController loginController;

    private JPanel wrapper= new JPanel();
    private JPanel pnl_logo= new JPanel();
    private JPanel pnl_login= new JPanel();
    private JLabel lbl_logo= new JLabel();
    private JLabel lbl_email= new JLabel();
    private JTextField txt_email= new JTextField();
    private JLabel lbl_password= new JLabel();
    private JTextField txt_password= new JTextField();
    private JButton btn_login= new JButton();

    public LoginUI(Query query, LoginController loginController){
        this.query = query;
        this.loginController = loginController;
        this.setLayout(new GridLayout(5, 5, 5, 5));
        
        this.setSize(1000,950);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y") - 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
   
        this.setResizable(false);
        this.setVisible(true);

        wrapper.setLayout(new GridLayout(3,1,5,5));
        wrapper.setVisible(true);;
        wrapper.setBounds(0, 0, 400, 400);

        pnl_logo.setLayout(new GridLayout(2,1,-1,-1));
        pnl_logo.setVisible(true);;
        pnl_logo.setBounds(0, 0, 3, 3);

        pnl_logo.setLayout(new GridLayout(2,1,-1,-1));
        pnl_logo.setVisible(true);;
        pnl_logo.setBounds(0, 0, 3, 3);


      
        wrapper.add(pnl_logo);       
        this.add(wrapper);
        this.setVisible(true);

        this.txt_password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btn_login.doClick();
                }
            }
        });

        // login
        btn_login.addActionListener(e -> {
           if(Helper.isFieldEmpty(txt_email) || Helper.isFieldEmpty(txt_password)){
               Helper.showMessage("validate");
           }else{
               User user = this.loginController.login(txt_email.getText(), txt_password.getText());
               if(user != null){
                   PatikaController patikaController = new PatikaController(this.query);
                   switch (user.getType()){
                       case "moderator": // Moderatör ise
                           ModeratorController moderatorController = new ModeratorController(user, this.query);
                           ModeratorUI moderatorUI = new ModeratorUI(user, moderatorController, patikaController, new CourseController(query, patikaController, moderatorController));
                           break;
                       case "educator": // Eğitmen ise
                           EducatorUI educatorUI = new EducatorUI(user, new EducatorController(user, this.query));
                           break;
                       default: // Öğrenci ise
                           StudentUI studentUI = new StudentUI(user, new StudentController(user, this.query), patikaController);
                           break;
                   }
                   this.dispose();
               }else{
                   Helper.showMessage("Kullanıcı adı veya paralo yanlış!");
               }
           }
        });
        txt_password.addKeyListener(new KeyAdapter() {
        });
    }

}
