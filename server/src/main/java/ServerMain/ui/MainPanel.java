package ServerMain.ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainPanel extends JPanel {
    public JTextArea textArea;
    public boolean serverState = false;

    public MainPanel() {
        setPreferredSize(new Dimension(200, 50));

        setFocusable(true);
        setName("mainPanel");
        Timer timerServerState = new Timer(1000,e->getServerState());
        initializeVariables();
        timerServerState.start();
        repaint();
    }

    private void initializeVariables(){
        textArea = new JTextArea();
        add(textArea);
        Font myFont = new FontUIResource("new font",0,20);
        textArea.setFont(myFont);
        textArea.setEditable(false);
        repaint();
    }

    private void getServerState(){
        Process process;
        String[] cmd = {"curl","localhost:8080/checkstate"};
        try {
            process = Runtime.getRuntime().exec(cmd);
            InputStream stdout = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
            String line1;
            while ((line1 = reader.readLine()) != null) {
                if(line1.equals("1")){
                    serverState = true;
                    textArea.setText("your server is ok");
                    return;
                }
            }
            serverState = false;
            textArea.setText("your server is not ok");
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
