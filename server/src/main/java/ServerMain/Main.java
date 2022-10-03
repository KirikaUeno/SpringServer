package ServerMain;

import ServerMain.spring.SpringApplicationMain;
import ServerMain.ui.MainFrame;
import org.springframework.boot.SpringApplication;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("aa");
		System.out.println("main called");
		SwingUtilities.invokeLater(MainFrame::new);
		SpringApplication.run(SpringApplicationMain.class, args);
	}
}
