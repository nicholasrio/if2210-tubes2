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
	JWebBrowser webBrowser;
	public YoutubeMediaPlayer (String URL)
	{
	     super(new BorderLayout()); 
		 JPanel webBrowserPanel = new JPanel(new BorderLayout());
		 webBrowserPanel.setBorder(BorderFactory.createTitledBorder(""));
		 webBrowser = new JWebBrowser();
		 webBrowser.navigate(URL);
		 webBrowser.setBarsVisible(false);
		 webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		 add(webBrowserPanel, BorderLayout.CENTER);
	}
	public void setURL (String URL)
	{
		 webBrowser.navigate(URL);		
	}
}
