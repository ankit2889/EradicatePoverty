package userInterface;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;

import javax.swing.*;
import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {
        Browser browser = BrowserFactory.create();

        JFrame frame = new JFrame("Hello World!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JInternalFrame frame1 = new JInternalFrame("Hello World!");
        frame.add(frame1);
        frame1.setVisible(true);
        frame1.add(browser.getView().getComponent(), BorderLayout.CENTER);
        frame.setSize(600, 500);
        frame1.setSize(400,300);
        frame.setVisible(true);

        browser.loadURL("http://maps.google.com");
    }
}