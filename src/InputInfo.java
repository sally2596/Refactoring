import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class InputInfo extends JFrame {
    static JTextField t1;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    public InputInfo()
    {

        JPanel panel = new JPanel();
        add(panel);
        panel.setPreferredSize(new Dimension(1000, 800));
        panel.setBackground(Color.white);

        GridLayout g1 = new GridLayout(2, 1, 0, 0);
        panel.setLayout(g1);

        JPanel UPpanel = new JPanel();
        JPanel DOWNpanel = new JPanel();
        UPpanel.setBackground(Color.white);
        DOWNpanel.setBackground(Color.white);

        panel.add(UPpanel);
        panel.add(DOWNpanel);

        ImageIcon image1 = new ImageIcon("images/InputStmt.PNG");

        JLabel label = new JLabel(image1);
        UPpanel.add(label);


        t1 = new JTextField(10);
        JButton btn1 = new JButton(new ImageIcon("images/Input.PNG"));
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);

        DOWNpanel.add(t1);
        DOWNpanel.add(btn1);

        btn1.addActionListener(new ActionListenerInput());


    }


    public class ActionListenerInput implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton)e.getSource();
            try {
                System.out.println("Input nickname");
                int cnt = 0;
                String queryNorE = "select cnt_win from ranking where name = ?";
                pstmt=Database.con.prepareStatement(queryNorE);
                System.out.println("1");
                pstmt.setString(1, t1.getText());
                System.out.println("2");
                rs = pstmt.executeQuery();
                System.out.println("3");


                if(rs.next()) {
                    System.out.println("4");
                    System.out.println("You're an existing member!");
                    String queryScore = "select cnt_win from ranking where name = ?";
                    pstmt=Database.con.prepareStatement(queryScore);
                    pstmt.setString(1, t1.getText());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        cnt = rs.getInt(1);
                    }
                    System.out.println("5");
                    cnt++;

                    String query = "UPDATE ranking SET cnt_win = ? where name = ?";
                    pstmt = Database.con.prepareStatement(query);
                    pstmt.setInt(1, cnt);
                    pstmt.setString(2, t1.getText());
                    System.out.println("6");
                    pstmt.executeUpdate();

                }
                else
                {
                    System.out.println("7");
                    System.out.println("You're an new member!");
                    String queryNEW = "INSERT INTO ranking VALUES (?,?)";

                    pstmt = Database.con.prepareStatement(queryNEW);
                    pstmt.setString(1, t1.getText());
                    pstmt.setInt(2, 1);
                    pstmt.executeUpdate();
                }
                System.out.println("Input success");
                btn.setEnabled(false);

            }catch (Exception e1) {
                System.out.println("Input fail");
            }


        }
    }


}
