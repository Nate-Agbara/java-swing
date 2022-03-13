import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Draffitti_Gui {
    private JPanel Mainpanel;
    private JPanel Startuppage;
    private JButton signUpButton;
    private JButton loginButton;
    private JPanel signuppage;
    private JTextField user_name;
    private JTextField user_email;
    private JPasswordField user_password;
    private JPasswordField user_Reinputpassword;
    private JTextField user_cellnumber;
    private JTextField user_address;
    private JButton mainMenuButton;
    private JButton signUpButton1;
    private JPanel Loginpage;
    private JTextField Userlogin_email;
    private JPasswordField userlogin_password;
    private JButton loginButton1;
    private JButton mainMenuButton1;
    private JButton signUpButton2;
    private JPanel productspage;
    private JLabel t_shirt;
    private JLabel sweatshirt_label;
    private JLabel pants_label;
    private JButton gildanTeeButton;
    private JButton gildanSweatshirtButton;
    private JButton pantsButton;
    private JLabel fitted_capLabel;
    private JButton fittedCapButton;
    private JLabel custom_painting;
    private JButton customPaintingButton;
    private JButton shoppingCartButton;
    private JButton accountButton;
    private JLabel logoLabel;
    private JPanel teeshirtpage;
    private JLabel teeshirt_page;
    private JTextField textField1;
    private JButton addToCartButton;
    private JRadioButton lRadioButton;
    private JRadioButton mRadioButton;
    private JRadioButton sRadioButton;
    private JRadioButton xlRadioButton;
    private JRadioButton rRadioButton;


    public Draffitti_Gui() {
        Startuppage.setVisible(false);
        signuppage.setVisible(false);

        signUpButton.addActionListener(new ActionListener() { // panel 1 sign up
            @Override
            public void actionPerformed(ActionEvent e) {
                Startuppage.setVisible(false);
                signuppage.setVisible(true);
            }
        });

        mainMenuButton.addActionListener(new ActionListener() { // panel 2 Main page
            @Override
            public void actionPerformed(ActionEvent e) {

                signuppage.setVisible(false);
//                Startuppage.setVisible(true);
                Loginpage.setVisible(true);
            }
        });
        mainMenuButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginpage.setVisible(false);
                Startuppage.setVisible(true);

            }
        });
        signUpButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginpage.setVisible(false);
                signuppage.setVisible(true);

            }
        });
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginpage.setVisible(false);
                productspage.setVisible(true);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startuppage.setVisible(false);
                Loginpage.setVisible(true);


            }
        });
        signUpButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              signuppage.setVisible(false);
//                productspage.setVisible(true);
                String name = user_name.getText();
                String email = user_email.getText();
                String password = String.valueOf(user_password.getPassword());
                String repassword = String.valueOf(user_Reinputpassword.getPassword());
                String cell = user_cellnumber.getText();
                String address = user_address.getText();

                String msg = "" + name;
                msg += " \n";
                if(name.isEmpty() || email.isEmpty() || password.isEmpty() || cell.isEmpty() || address.isEmpty()){
                    JOptionPane.showMessageDialog(signUpButton1,
                            "please enter all fields!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!repassword.equals(password)) {
                    System.out.println("password incorrectly re-entered!");
                    JOptionPane.showMessageDialog(signUpButton1,
                            "password mismatch!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/draffitti", "root", "root123");

                    String query = "INSERT INTO account (name, email, password, PhoneNumber, address) " +
                            "values(?, ?, ?, ?, ?)";

//                    Statement sta = connection.createStatement();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, cell);
                    preparedStatement.setString(5, address);
                    int x = preparedStatement.executeUpdate();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(signUpButton1,
                                "User not created!",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        System.out.println("user added");
                        JOptionPane.showMessageDialog(signUpButton1,
                                "User created successfully!" +
                                        "\n"+
                                        "Proceed to login.",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    preparedStatement.close();
                    connection.close();
                } catch (Exception exception) {
                    System.out.println("we encountered an exception:");
                    exception.printStackTrace();
                }

            }
        });
        gildanTeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productspage.setVisible(false);
                teeshirtpage.setVisible(true);
            }
        });
//        signUpButton1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }
    String name = user_name.getText();
    String email = user_email.getText();
    String password = String.valueOf(user_password.getPassword());
    String repassword = String.valueOf(user_Reinputpassword.getPassword());
    String cell = user_cellnumber.getText();
    String address = user_address.getText();


    private void createUIComponents() {
      //t_shirt = new JLabel(new ImageIcon("Images/teeshirt.png"));
        t_shirt = new JLabel();
        ImageIcon tshirt_icon = new ImageIcon(new ImageIcon("Images/teeshirt.png").getImage().getScaledInstance(200,250,Image.SCALE_SMOOTH));
        t_shirt.setIcon(tshirt_icon);

        sweatshirt_label = new JLabel();
        ImageIcon sweatshirt_icon = new ImageIcon(new ImageIcon("Images/sweatshirt.png").getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH));
        sweatshirt_label.setIcon(sweatshirt_icon);

        pants_label = new JLabel();
        ImageIcon pants_icon = new ImageIcon(new ImageIcon("Images/pants.png").getImage().getScaledInstance(200, 250,Image.SCALE_SMOOTH));
        pants_label.setIcon(pants_icon);

        fitted_capLabel = new JLabel();
        ImageIcon cap_icon = new ImageIcon(new ImageIcon("Images/fittedcap.png").getImage().getScaledInstance(200,130,Image.SCALE_SMOOTH));
        fitted_capLabel.setIcon(cap_icon);

        custom_painting = new JLabel();
        ImageIcon painting = new ImageIcon(new ImageIcon("Images/poster.png").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        custom_painting.setIcon(painting);

        logoLabel = new JLabel();
        ImageIcon logo = new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
        logoLabel.setIcon(logo);



        String tees = "Images/teeshirt.png";
        ImageIcon tee = new ImageIcon();
        teeshirt_page = new JLabel();
        image(teeshirt_page, tees, tee);



        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new Draffitti_Gui().Mainpanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public static void image(JLabel label, String filename, ImageIcon icon){

        icon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(500,600,Image.SCALE_SMOOTH));
        label.setIcon(icon);

    }
}
