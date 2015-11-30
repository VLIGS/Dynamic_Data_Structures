package Tests;

import Stack.*;
import Support.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ImprovedStackImplTests {
    @Test
    public void isEmptyTest()
    {
        boolean output;
        boolean expected = true;
        ImprovedStackImpl myStack = new ImprovedStackImpl();
        output = myStack.isEmpty();
        assertEquals(output, expected);
    }

    @Test
    public void sizeTest()
    {
        int expected=15;
        int output;
        ImprovedStackImpl myStack = new ImprovedStackImpl();

        for (int i = 0; i < 15; i++)
        {
            myStack.push(i);
        }
        output=myStack.size();
        assertEquals(output, expected);
    }

    @Test
    public void pushTest()
    {
        Object expected = "two";
        Object output;
        ImprovedStackImpl myStack = new ImprovedStackImpl();
        myStack.push("zero");
        myStack.push("one");
        myStack.push("two");
        output = myStack.top().getReturnValue();
        assertEquals(output, expected);
    }

    @Test
    public void topTest()
    {
        Object expected;
        Object output;

        //test empty stack
        expected = ErrorMessage.EMPTY_STRUCTURE;
        ImprovedStackImpl myStack = new ImprovedStackImpl();
        output = myStack.top().getError();
        assertEquals(output, expected);

        //test legal call
        expected = "two";
        myStack.push("zero");
        myStack.push("one");
        myStack.push("two");
        output = myStack.top().getReturnValue();
        assertEquals(output, expected);
        output =null;
        output = myStack.top().getReturnValue();
        assertEquals(output, expected);

    }

    @Test
    public void popTest()
    {
        Object expected;
        Object output;

        //test empty stack
        expected = ErrorMessage.EMPTY_STRUCTURE;
        ImprovedStackImpl myStack = new ImprovedStackImpl();
        output = myStack.top().getError();
        assertEquals(output, expected);

        //test legal call
        expected = "two";
        myStack.push("zero");
        myStack.push("one");
        myStack.push("two");
        output = myStack.pop().getReturnValue();
        assertEquals(output, expected);
        expected = "one";
        output =null;
        output = myStack.pop().getReturnValue();
        assertEquals(output, expected);
    }

    @Test
    public void reverseTest()
    {
        Object expected;
        Object output;
        int mySize;
        ImprovedStack myOriginalStack = new ImprovedStackImpl();
        ImprovedStack myReversedStack1 = new ImprovedStackImpl();
        ImprovedStack myReversedStack2 = new ImprovedStackImpl();

        myOriginalStack.push("zero");
        myOriginalStack.push("one");
        myOriginalStack.push("two");

        myReversedStack2.push("two");
        myReversedStack2.push("one");
        myReversedStack2.push("zero");

        mySize = myOriginalStack.size();
        myReversedStack1 = myOriginalStack.reverse();

        for (int i = 0; i<mySize;i++)
        {
            expected = myReversedStack2.pop().getReturnValue();
            output = myReversedStack1.pop().getReturnValue();
            assertEquals(output, expected);
            expected = null;
            output = null;
        }
    }

    @Test
    public void removeTest()
    {
        Object expected;
        Object output;
        int mySize;
        ImprovedStack myOriginalStack = new ImprovedStackImpl();
        ImprovedStack myTestStack = new ImprovedStackImpl();

        myOriginalStack.push("zero");
        myOriginalStack.push("decoy");
        myOriginalStack.push("one");
        myOriginalStack.push("decoy");
        myOriginalStack.push("two");

        myOriginalStack.remove("decoy");

        myTestStack.push("zero");
        myTestStack.push("one");
        myTestStack.push("two");

        mySize=myOriginalStack.size();

        for (int i = 0; i<mySize;i++)
        {
            expected = myTestStack.pop().getReturnValue();
            output = myOriginalStack.pop().getReturnValue();
            assertEquals(output, expected);
            expected = null;
            output = null;
        }
    }
}
