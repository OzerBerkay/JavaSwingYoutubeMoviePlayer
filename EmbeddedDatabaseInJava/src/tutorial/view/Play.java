/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.view;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Berkay
 */
public class Play {
     public Play(String link) {
        
        NativeInterface.open();
        run(link);
    }

    public void run(String link) {
        JFrame frame = new JFrame("Movie Player");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(getBrowserPanel(link), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public JPanel getBrowserPanel(String link) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowser.setBarsVisible(false);
        webBrowser.navigate(link);
        return webBrowserPanel;
    }
}
