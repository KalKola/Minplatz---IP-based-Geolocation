import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    // GUI frame and panel declaration
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    // create text field for submitting ip address
    JTextField textField = new JTextField("Enter IP Address");

    // create display labels for location info
    private JLabel ipLabel = new JLabel("");
    private JLabel cityLabel = new JLabel("");
    private JLabel countryLabel = new JLabel("");

    // info to display
    private String loc = "";
    private JSONObject jsObj = null;
    String city;
    String country;
    String ipAddress;

    public Gui() {

        JButton button = new JButton("Submit");
        button.addActionListener(this);

        // initialise panel with borders and submit button
        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        //panel.setLayout(new BorderLayout());
        panel.add(button);

        // add textfield
        panel.add(textField);

        // add labels
        panel.add(ipLabel);
        panel.add(cityLabel);
        panel.add(countryLabel);

        // change window color
        panel.setBackground(Color.LIGHT_GRAY);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Minplatz");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        // read in text field, set blank if default text
        String userIp = textField.getText();
        if (userIp.equals("Enter IP Address")) {
            userIp = "";
        }

        loc = Main.getLocation(userIp);
        jsObj = new JSONObject(loc);

        ipAddress = jsObj.getString("ip");
        city = jsObj.getString("city");
        country = jsObj.getString("country");

        ipLabel.setText(ipAddress);
        cityLabel.setText(city);
        countryLabel.setText(country);
    }
}
