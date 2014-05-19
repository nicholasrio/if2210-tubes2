package RSSep;

public class MainConsole {
	public static void main(String[] args) {
		tubesOOPDemo demo = null;
		try{
			demo = new tubesOOPDemo();
			if(demo == null){
				throw new customException();
			}
			demo.runConsole();
		}
		catch(customException e){
			
		}
	} 
}
