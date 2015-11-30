package Tests;

import List.LinkedList;
import List.List;
import Stack.StackImpl;
import Support.ErrorMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackImplTests {

        @Test
        public void isEmptyTest()
        {
            boolean output;
            boolean expected = true;
            List myList = new LinkedList();
            StackImpl myStack = new StackImpl(myList);
            output = myStack.isEmpty();
            assertEquals(output, expected);
        }

        @Test
        public void sizeTest()
        {
            int expected=15;
            int output;
            List myList = new LinkedList();
            StackImpl myStack = new StackImpl(myList);

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
            List myList = new LinkedList();
            StackImpl myStack = new StackImpl(myList);
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
            List myList = new LinkedList();
            StackImpl myStack = new StackImpl(myList);
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
            List myList = new LinkedList();
            StackImpl myStack = new StackImpl(myList);
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
}
