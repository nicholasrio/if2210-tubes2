/**
 * author tegarnization
 * */


package VideoPlayer;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * Youtube Media Player responsible to browse youtube video based on URL
 * */
@SuppressWarnings("serial")

public class YoutubeMediaPlayer extends JPanel 
{   
	/**
	 * webBrowser bertanggung jawab untuk menampilkan video youtube
	 */
	JWebBrowser webBrowser;
	/**
	 * Konstruktor untuk Youtube Media Player, akan mengenerate native browser pada sebuah kelas yang diturunkan dari JPanel 
     * @param URL
	 */
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
	/**
	 * Mengeset URL untuk mengganti URL video yang ada di JWebBrowser
     * @param URL
	 */
	public void setURL (String URL)
	{
		 webBrowser.navigate(URL);		
	}
}
