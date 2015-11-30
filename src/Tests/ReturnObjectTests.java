package Tests;
import Support.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectTests {
    @Test
    public void hasErrorTest()
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();

        /**
         * ReturnObject defaults to no error
         * expect test to return false result
         */

        boolean expected = false;
        boolean output = myObject.hasError();
        assertEquals(output, expected);

        /**
         * set ReturnObject to contain error
         * expect test to return true result
         */
        myObject.setErrorMessage(ErrorMessage.EMPTY_STRUCTURE);
        expected = true;
        output = myObject.hasError();
        assertEquals(output, expected);
    }

    @Test
    public void getErrorTest() {

        ReturnObjectImpl myObject = new ReturnObjectImpl();
        /**
         * ReturnObject defaults to no error
         * expect test to return NO_ERROR result
         */
        ErrorMessage expected = ErrorMessage.NO_ERROR;
        ErrorMessage output = myObject.getError();
        assertEquals(output, expected);

        /**
         * set ReturnObject to contain error EMPTY_STRUCTURE
         * expect test to return EMPTY_STRUCTURE ErrorMessage
         */

        myObject.setErrorMessage(ErrorMessage.EMPTY_STRUCTURE);
        expected = ErrorMessage.EMPTY_STRUCTURE;
        output = myObject.getError();
        assertEquals(output, expected);
    }

    @Test
    public void getReturnValueTest()
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();

        /**
         * test that correct Object is returned when operation is successful
         */

        String expected = "Test";
        Object output;
        myObject.setMyObject("Test");
        output = myObject.getReturnValue();
        assertEquals(output, expected);

        /**
         * test that null is returned if there has been error
         */

        myObject.setErrorMessage(ErrorMessage.EMPTY_STRUCTURE);
        assertNull(myObject.getReturnValue());


    }
}
