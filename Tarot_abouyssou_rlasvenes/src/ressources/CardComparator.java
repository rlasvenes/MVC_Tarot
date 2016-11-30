package ressources;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		int returnValue = 0;
		switch(o1.getSymbole()){
			
			
		case "Pique":
			if(o2.getSymbole()=="Pique")
				
				if(o1.getValue()<o2.getValue())
					returnValue=-1;
			
				else if(o1.getValue()==o2.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else
				returnValue=-1;
			
			break;
			
			
			
		case "Coeur":
			
			if(o2.getSymbole()=="Pique")
					returnValue=1;
	
			else if(o2.getSymbole()=="Coeur")
				
				if(o1.getValue()<o2.getValue())
					returnValue=-1;
			
				else if(o1.getValue()==o2.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else
				returnValue=-1;
			
			break;
			
		case "Carreau":
			
			if(o2.getSymbole()=="Pique" || o2.getSymbole()=="Coeur")
				returnValue=1;
			
			else if(o2.getSymbole()=="Carreau")
				
				if(o1.getValue()<o2.getValue())
					returnValue=-1;
			
				else if(o1.getValue()==o2.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			else 
				
				returnValue=-1;
			
			break;
			
		case "Trefle":
			
			if(o2.getSymbole()=="Pique" || o2.getSymbole()=="Coeur" || o2.getSymbole()=="Carreau")
				returnValue=1;
			
			else if(o2.getSymbole()=="Trefle")
				
				if(o1.getValue()<o2.getValue())
					returnValue=-1;
			
				else if(o1.getValue()==o2.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else 
				returnValue=-1;
			
			 break;
			 
				
				case "Atout":
					
					if(o2.getSymbole()=="Pique" || o2.getSymbole()=="Coeur" || o2.getSymbole()=="Carreau" || o2.getSymbole()=="Trefle")
						returnValue=1;
					
					else
						
						if(o1.getValue()<o2.getValue())
							returnValue=-1;
					
						else if(o1.getValue()==o2.getValue())
							returnValue=0;
					
						else 
							returnValue=1;
					
			
					
					 break;
					 
				case "Excuse":
					if(o2.getSymbole()=="Pique" || o2.getSymbole()=="Coeur" || o2.getSymbole()=="Carreau" || o2.getSymbole()=="Trefle")
						returnValue=1;
					
					else
						returnValue=-1;
		
			 
			 
			 default:
			 break;
		}
		
				
			 return returnValue;
	}
}
			
		
			


	


