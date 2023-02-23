import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IP_tracker extends JFrame implements ActionListener {
    JTextField t;
    JButton b1,b2;
    JLabel l1;
    public IpFinder(){
        super("IP Finder");
        t=new JTextField();
        t.setBounds(100,100,200,20);
        b1 =new JButton("Search for the IP");
        b1.setBounds(100,200,100,3);
        b2=new JButton("Exit");
        b2.setBounds(230,200,70,30);
        l1= new JLabel("IP Finder");
        l1.setBounds(120,40,300,20);
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
