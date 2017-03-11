package cs.uwf.edu.bomb.expert;


public class BotTester 
{

	public static void main(String[] args) 
	{
		System.out.println("***Bot Started***\n.");
		Bomb theBomb = new Bomb();
		
		//get bomb information
		theBomb.getBombInfo();
		
		//get module name
		System.out.println("Ready to solve modules.\n");
		
		while(!theBomb.getIsSolved()){
			theBomb.getModNameFromUser();
			
			if(theBomb.getCurrentModuleName().equalsIgnoreCase("done")){
				theBomb.setIsSolved(true);
			}
			else{
				//get info required to set the module
				theBomb.setTheModule(theBomb.getModInfo());
				
				//solve the module
				theBomb.getTheModule().solve();
			}
		}
		
		
		
		//user input module name
		//String moduleName = sc.nextLine();
		//Gets the module name and makes sure its valid
		//solve the module
		
		
		// theBomb.getTheModule().solve();
		
		//bot confirm that the module name was heard correctly
		
		//Bot asks for first user input
		
		//user provides input
		
		
		//Close the application
		System.out.println("Goodbye");
		
		System.exit(0);
		
		
		
		

	}

}
