import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;


public class AssignmentMarker { 
	
	private static float totalMarksLost = 0;
	/*
	 * We test List and Deque together (because Deque is built off List, and 
	 * the tests are very similar in nature). 
	 */
	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		ListTest.class, 
		StackTest.class, 
		QueueTest.class,
		ListExceptionTest.class,
		StackExceptionTest.class,
		QueueExceptionTest.class,
		ListCollectionInterfaceTest.class,
		QueueCollectionInterfaceTest.class,
		StackCollectionInterfaceTest.class
	})
	private class CollectionsSuite { }

	/*
	 * The calculator tests are spread over several classes because it makes more 
	 * logical sense that way. Many tests are parameterized, which is tough to do 
	 * in a single class. 
	 */
	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		PrecedenceTest.class,
		InfixToPostfixTest.class,
		InfixToPostfixErrorTest.class,
		PostfixEvaluation.class
	})
	private class CalculatorSuite { }
	
	private static java.util.ArrayList<Failure> failures;
	
	
	// Run the test. 
	private static float testrunner(String name, Class c) {
		Result test = JUnitCore.runClasses(c);
		failures.addAll(test.getFailures());
			
		float marksLost = 0.0f;
		for ( int i = 0 ; i < test.getFailures().size() ; ++i ) {
		//	System.out.println("Failed test: " + test.getFailures().get(i).getDescription().getClassName() + ":" + 
		//		test.getFailures().get(i).getDescription().getMethodName());
			
			String testID = test.getFailures().get(i).getDescription().getClassName() + ":" + 
					test.getFailures().get(i).getDescription().getMethodName();
			testID = testID.replaceAll("Test", ""). replaceAll("test", ""); // Strip the word "test" from the identifying string. 
			marksLost += MarksMap.getInstance().getMark(testID);
		}

		
		System.out.println("Marks lost: " + marksLost);
		float marksGained = MarksMap.getInstance().getMark(name) - marksLost;
		
		float possibleMarks = MarksMap.getInstance().getMark(name);
		System.out.println(name + " results: [" + marksGained + "/" + possibleMarks + "]");
		
		totalMarksLost += marksLost;
		return marksGained;
	}
	
	// Simple test information
	private static float runATest(String name, Class c) {
		System.out.println("\n" + name);
		for ( int i = 0 ; i < name.length() ; ++i ) 
			System.out.print("-");
		System.out.println();
		
		return testrunner(name, c);
	}
	
	// More complex test information
	private static float runATest(String name, String message, Class c) {
		System.out.println("\n" + name + ": " + message);
		for ( int i = 0 ; i < name.length() + message.length() + 2; ++i ) 
			System.out.print("-");
		System.out.println();
	
		float mark = testrunner(name, c);
		
		System.out.println("Important: " + message);
		
		return mark;
	}
	
	public static void main(String[] args) {
		float marks = 0;
	
		failures = new java.util.ArrayList<Failure>();
		
		System.out.println("Data Structures Assignment #1:\n\tReverse Polish Notation Calculator.\n");
		
		/*
		 * We have tests for Node, but because it's not implemented by the students it's not run by default. 
		 */
		//runATest("Node", "All these tests should pass. This class is not implemented by you.", NodeTest.class);
	
		System.out.println("-----------------------------");
		marks += runATest("Token", "(No marks for Token.java implementation [but it's a critical class to implement])",
				TokenTest.class);

		marks += runATest("List", ListTest.class);
		marks += runATest("List:CollectionInterface", ListCollectionInterfaceTest.class);
		
		marks += runATest("Stack", StackTest.class);
		marks += runATest("StackCollectionInterface", StackCollectionInterfaceTest.class);
		
		marks += runATest("Queue", QueueTest.class);
		marks += runATest("QueueCollectionInterface", QueueCollectionInterfaceTest.class);

		
		System.out.println("Current marks: " + marks);
		System.out.println("\nPart 2: Calculator logic");
		System.out.println("-----------------------------");
		
		//marks += runATest("Precedence", PrecedenceTest.class);
		marks += runATest("InfixToPostfix", InfixToPostfixTest.class);
		marks += runATest("PostfixEvaluation", PostfixEvaluation.class);
		
		
		System.out.println("-----------------------------");
		System.out.println("\nFailed test details");
		System.out.println("( Test area: test name -> Error details)\n");
		for (Failure failure : failures) {
			String name = failure.getDescription().getClassName().replaceAll("Test",  "") 
					+ ": " +  failure.getDescription().getMethodName();
			System.out.print(name + " -> ");
			if ( failure.getMessage() != null )
				System.out.print(failure.getMessage());
			else
				System.out.print("No failure message present " +
						"(indicates systemic issues somewhere in the codebase)." +
						"\nTrace: " + failure.getTrace());
			System.out.print("\n");
		}

		
		System.out.println("Total marks: " + marks + " (lost: " + totalMarksLost + " marks)");
	}
}  
