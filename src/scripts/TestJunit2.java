package scripts;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import java.lang.Object;

public class TestJunit2 {

   String message = "Robert";	
//
 
   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      org.junit.Assert.assertEquals("failure - strings are not equal", "text", "text");
   }
}
