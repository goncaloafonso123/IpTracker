import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP_tracker extends JFrame implements ActionListener {
    JTextField t;
    JButton b1,b2;
    JLabel l1;
    public IP_tracker(){
        super("IP Finder");
        t=new JTextField();
        t.setBounds(100,100,200,20);
        b1 =new JButton("Search");
        b1.setBounds(100,200,100,30);
        b2=new JButton("Exit");
        b2.setBounds(230,200,70,30);
        l1= new JLabel("IP Finder");
        l1.setBounds(120,40,300,20);
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(t);
        add(b1);
        add(b2);
        add(l1);
        setSize(430,400);
        setVisible(true);
        setTitle("IP Tracker");
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
new IP_tracker();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Search")){
            try{
                String url = t.getText();
                InetAddress inet = InetAddress.getByName(url);
                String ip = inet.getHostAddress();
                JOptionPane.showMessageDialog(this,ip);

            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(this,"Not a valid URL","Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (str.equals("Exit")){
            dispose();
            repaint();
        }
    }
}
