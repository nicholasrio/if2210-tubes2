package RSS.slidinglayout;

import aurelienribon.tweenengine.TweenManager;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLayeredPane;

public class SLPanel extends JLayeredPane {
	private TweenManager tweenManager;
	SLConfig currentCfg;
	boolean isTransitionPlaying = false;

	public SLPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override public void componentResized(ComponentEvent e) {
				if (currentCfg != null) initialize(currentCfg);
			}
		});
	}

	/**
	 * Sets the {@link TweenManager} that will be used to animate the
	 * transitions. You can use the {@link SLAnimator} class to create a new
	 * manager that wil run in a dedicated thread, or you can pass any
	 * manager if you already have one running in a thread.
	 */
	public void setTweenManager(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
	}

	/**
	 * Sets the initial configuration of the panel. This configuration will be
	 * enforced without transition. Do not forget to call this before starting
	 * any transition!
	 */
	public void initialize(SLConfig cfg) {
		currentCfg = cfg;

		if (getWidth() != 0 || getHeight() != 0) {
			cfg.placeAndRoute();

			removeAll();
			for (Component c : cfg.getCmps()) {
				SLConfig.Tile t = cfg.getTile(c);
				c.setBounds(t.x, t.y, t.w, t.h);
				c.validate();
				add(c, new Integer(1));
			}
		}
	}

	/**
	 * Creates a new transition. Do not hesitate to chain the method calls
	 * from this one, the API is meant for that.
	 */
	public SLTransition createTransition() {
		return new SLTransition(this, tweenManager);
	}
}
