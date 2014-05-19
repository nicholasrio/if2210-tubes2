package RSSep;

public class MainGUI {
	public static void main(String[] args) {
		tubesOOPDemo demo = null;
		try{
			demo = new tubesOOPDemo();
			if(demo == null){
				throw new customException();
			}
			demo.runGUI();
		}
		catch(customException e){
			
		}
	} 
}
