package project_java;
import java.util.ArrayList;

public class IdMaker {
	
	static public int makeUniqueID(ArrayList<Integer> idList) {
		int uniqueID;
        do 
        {
           uniqueID = (int) (Math.random() * 1000);
        } 
        while (idList.contains(uniqueID));
        
        idList.add(uniqueID);
        
        return uniqueID;		
	}
}
