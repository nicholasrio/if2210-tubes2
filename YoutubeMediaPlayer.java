import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class YoutubeMediaPlayer {

public static void main(String[] args) 
{
    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() 
    {	
        public void run() 
        {
            JFrame frame = new JFrame("YouTube Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        }
    });
    NativeInterface.runEventPump();
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            NativeInterface.close();
        }
    }));
}

public static JPanel getBrowserPanel() 
{
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    JWebBrowser webBrowser = new JWebBrowser();
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    webBrowser.setBarsVisible(false);
    /*Ibrahimovic Goal*/
    webBrowser.navigate("http://www.youtube.com/watch?v=JnRYo75KSyQ");
    return webBrowserPanel;
}
}