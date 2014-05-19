/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;
import java.awt.image.BufferedImage;
/**
 *
 * @author kevinyu
 */
public class Animation {
    
    //sprite animasi frame
    private BufferedImage[] frames;
   
    //frame sekarang
    private int currentFrame;
    
    //waktu mulai animasi
    private long startTime;
    
    //waktu transisi frame
    private long delay;
    
    //flag menadakan animasi sudah pernah dimainkan
    private boolean playedOnce;

    /**
     * Constructor
     */
        public void Animation() {
	playedOnce = false;
    }
    
    //Pindah Frame

    /**
     * reset the frames
     * @param frames list of bufferedImage
     */
        public void setFrames(BufferedImage[] frames) {
	this.frames = frames;
	currentFrame = 0;
	startTime = System.nanoTime();
	playedOnce = false;
    }
    
    //Atur waktu transisi antar frame

    /**
     * set frame delay
     * @param d delay time
     */
        public void setDelay(long d) { delay = d; }
    
    //pindah frame

    /**
     * change frame based on index
     * @param i the selected index frame
     */
    public void setFrame(int i) { currentFrame = i; }
	
    /**
     * update the animations
     */
    public void update() {
		
	if(delay == -1) return;
		
	long elapsed = (System.nanoTime() - startTime) / 1000000;
	if(elapsed > delay) {
            currentFrame++;
            startTime = System.nanoTime();
	}
	if(currentFrame == frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
		
    }
    
    /**
     * get current index frame
     * @return the index of active frame
     */
    public int getFrame() { return currentFrame; }

    /**
     * get current image frame
     * @return buffered image.
     */
    public BufferedImage getImage() { return frames[currentFrame]; }

    /**
     * check if the frame has played
     * @return boolean.
     */
    public boolean hasPlayedOnce() { return playedOnce; }
}
