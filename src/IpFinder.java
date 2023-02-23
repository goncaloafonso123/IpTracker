import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class IpFinder extends JFrame implements ActionListener {
    private JLabel enterUrlLabel = new JLabel("Enter URL:");
    private JTextField urlField = new JTextField();
    private JButton findIpButton = new JButton("Find IP");
    private JButton exitButton = new JButton("Exit");

    public IpFinder() {
        setTitle("IP Finder");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 10));

        // Create a header panel with title and welcome message
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(40, 40, 40));
        JLabel titleLabel = new JLabel("IP FINDER");
        titleLabel.setForeground(new Color(250, 250, 250));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(10));
        JLabel welcomeLabel = new JLabel("Welcome! Enter a URL to find its IP address.");
        welcomeLabel.setForeground(new Color(200, 200, 200));
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(welcomeLabel);
        headerPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Create a content panel with input fields and buttons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(250, 250, 250));
        enterUrlLabel.setBounds(50, 50, 200, 30);
        enterUrlLabel.setFont(new Font("Arial", Font.BOLD, 16));
        urlField.setBounds(50, 80, 400, 30);
        findIpButton.setBounds(300, 130, 150, 30);
        findIpButton.setFont(new Font("Arial", Font.BOLD, 16));
        findIpButton.addActionListener(this);
        exitButton.setBounds(50, 130, 150, 30);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(this);
        contentPanel.add(enterUrlLabel);
        contentPanel.add(urlField);
        contentPanel.add(findIpButton);
        contentPanel.add(exitButton);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Create a footer panel with credits
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        footerPanel.setBackground(new Color(40, 40, 40));
        footerPanel.add(Box.createVerticalStrut(10));
        footerPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(this, "Welcome to IP Finder! Try entering 'www.google.com' to see its IP address.");
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = urlField.getText();
        String command = e.getActionCommand();

        if (command.equals("Find IP")) {
            try {
                InetAddress ia = InetAddress.getByName(url);
                String ip = ia.getHostAddress();
                JOptionPane.showMessageDialog(this, "The IP Address of " + url + " is: " + ip);
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(this, "IP Address not found. Check URL!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Exit")) {
            dispose();
        }
    }
}