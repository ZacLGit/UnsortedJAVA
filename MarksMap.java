import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class MarksMap {

	private static final MarksMap map = new MarksMap();
	private Map<String, Float> marks = new HashMap<String, Float>();
	private Map<String, Float> obtainedMarks = new HashMap<String, Float>();
	
	/*
	 * Private constructor to avoid non-singleton use. 
	 */
	private MarksMap() {
		// 5
		marks.put("Token",  	0.f);
			marks.put("Token:Equals", 0f);
			marks.put("Token:ToString", 0f);
            marks.put("Token:GetOperand", 0f);
            marks.put("Token:TokenFloat", 0f);
            marks.put("Token:TokenInt", 0f);
            marks.put("Token:HashCode", 0f);
            marks.put("Token:GetOperator", 0f);
            marks.put("Token:GetPrecedence", 0f);
            marks.put("Token:TokenString", 0f);

        marks.put("Node",  0f);
        	marks.put("Node:ToString", 0f);
        	marks.put("Node:EqualsObject", 0f);
        	marks.put("Node:HashCode", 0f);

        // 55
		marks.put("Collection", 10.f);
		
		// We have an extra half a mark for this set of tests. 
		marks.put("List", 		24.5f);

			marks.put("List:List_Node", 				1f);
			marks.put("List:List_CopyConstructor", 		4.5f);

            marks.put("List:RemoveIntBeginning", 		1.5f);
            marks.put("List:RemoveIntEnd", 				1.5f);
            marks.put("List:RemoveInt",                	2f);
            
            marks.put("List:IndexOf",                   2f);
            marks.put("List:Get", 						2f);     

            marks.put("List:AddIntToken",               4f);
    
            marks.put("List:Contains", 		2f);
            
            marks.put("List:RemoveToken_Beginning", 	1f);
            marks.put("List:RemoveToken_End", 			1f);
            marks.put("List:RemoveToken_Middle", 		1f);
            marks.put("List:RemoveToken_Single",      	1f);
     
            // 10
		marks.put("List:CollectionInterface", 15.f);
			marks.put("ListCollectionInterface:AddNullPointer", 	1f);
			marks.put("ListCollectionInterface:Add",				2f);
			marks.put("ListCollectionInterface:HashCodeEquality", 	2f);	
		    marks.put("ListCollectionInterface:Size", 				2f);	
		    marks.put("ListCollectionInterface:Equality", 			4f);	
		    marks.put("ListCollectionInterface:ToString", 		2f);	
		    
		    marks.put("ListCollectionInterface:IsEmpty", 			2f);	
    		
		marks.put("Queue",		5.f);
            marks.put("Queue:Peek",  1f);
            marks.put("Queue:Poll",  1f);
            marks.put("Queue:Offer",  1f);
            marks.put("Queue:Queue", 1f);
            marks.put("Queue:Queue_CopyConstructor", 1f);

            
        marks.put("Stack",		5.f);
            marks.put("Stack:Pop",  1f);
            marks.put("Stack:Peek",  1f);
            marks.put("Stack:Push",  1f);
            //marks.put("Stack:IsEmpty",  1f);
            marks.put("Stack:Stack", 1f);
            marks.put("Stack:Stack_CopyConstructor", 1f);

		marks.put("StackCollectionInterface", 5f);
		    marks.put("StackCollectionInterface:HashCodeEquality", 	1f);	
		    marks.put("StackCollectionInterface:Size", 				.5f);	
		    marks.put("StackCollectionInterface:Equality", 			1f);	
		    marks.put("StackCollectionInterface:ToStringTest", 		1f);	
		    marks.put("StackCollectionInterface:AddNullPointer", 	.5f);	
		    marks.put("StackCollectionInterface:Add", 				0.5f);
		    marks.put("StackCollectionInterface:IsEmpty", 			.5f);
		    marks.put("StackCollectionInterface:ToString", 			1f);
		
		marks.put("QueueCollectionInterface", 5f);
		    marks.put("QueueCollectionInterface:HashCodeEquality", 	1f);	
		    marks.put("QueueCollectionInterface:Size", 				.5f);	
		    marks.put("QueueCollectionInterface:Equality", 			1f);	
		    marks.put("QueueCollectionInterface:ToStringTest", 		1f);	
		    marks.put("QueueCollectionInterface:AddNullPointer", 	.5f);
		    marks.put("QueueCollectionInterface:Add", 				0.5f);
		    marks.put("QueueCollectionInterface:IsEmpty", 			.5f);	
		    marks.put("QueueCollectionInterface:ToString", 			1f);
		
		
		marks.put("InfixToPostfix",   15.f);
			for ( int i = 0 ; i < 11 ; ++i )
				marks.put("InfixToPostfix:infixToPostfix[" + i + "]", 15.f/11.f);
		
		marks.put("PostfixEvaluation", 	15f);
			for ( int i = 0 ; i < 11 ; ++i ) 
				marks.put("PostfixEvaluation:postfixEvaluation[" + i + "]", 15.f / 11.f);
		// 100 marks total. 
		
	}
	
	public static MarksMap getInstance() {
		return map;
	}
	
	public float getMark(String name) {
		if ( !marks.containsKey(name) ) {
			if ( !name.contains("Failure") ) {
				System.out.print(name + " is not contained in the map: ");
			}
			return -1;
		}
		return marks.get(name);
	}
	
	public void addMarks(String key, Float mark) {
		marks.put(key, mark);
	}
	
	public void gainMark(String key, Float mark) {
		obtainedMarks.put(key, mark);
	}

}
