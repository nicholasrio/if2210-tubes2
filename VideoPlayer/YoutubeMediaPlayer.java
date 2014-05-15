/**
 * author tegarnization
 * */


package VideoPlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


/**
 * Youtube Media Player responsible to browse youtube video based on URL
 * */

public class YoutubeMediaPlayer {
	
	/**
	 * param VideoURL
	 * */

	public static JPanel getBrowserPanel(String VideoURL) 
	{
	    JPanel webBrowserPanel = new JPanel(new BorderLayout());
	    JWebBrowser webBrowser = new JWebBrowser();
	    webBrowser.setBarsVisible(false);
	    webBrowser.setMenuBarVisible(false);
	    webBrowser.setAutoscrolls(false);
	    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
	    webBrowser.setBarsVisible(false);
	    Dimension dimension = new Dimension();
	    dimension.height = 675;
	    dimension.width = 550;
	    webBrowser.navigate(VideoURL);
	    webBrowser.setButtonBarVisible(false);
	    webBrowser.setAutoscrolls(false);
	    webBrowserPanel.setAutoscrolls(false);
	    return webBrowserPanel;
	}
}