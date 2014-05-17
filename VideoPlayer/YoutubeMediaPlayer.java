/**
 * author tegarnization
 * */


package VideoPlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


/**
 * Youtube Media Player responsible to browse youtube video based on URL
 * */


@SuppressWarnings("serial")
public class YoutubeMediaPlayer extends JPanel 
{   
	public YoutubeMediaPlayer ()
	{
	     super(new BorderLayout()); 
		 JPanel webBrowserPanel = new JPanel(new BorderLayout());
		 webBrowserPanel.setBorder(BorderFactory.createTitledBorder(""));
		 final JWebBrowser webBrowser = new JWebBrowser();
		 webBrowser.navigate("http://www.youtube.com/v/aLSOdCF1St8&feature=youtube_gdata_player");
		 webBrowser.setBarsVisible(false);
		 webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		 add(webBrowserPanel, BorderLayout.CENTER);
	}
}
