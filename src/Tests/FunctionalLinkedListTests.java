package Tests;

import List.*;
import Support.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FunctionalLinkedListTests {


        @Test
        public void isEmptyTest(){

            List myList = new FunctionalLinkedList();

            boolean outputArrayList;
            boolean expected = true;

            outputArrayList = myList.isEmpty();
            assertEquals(outputArrayList,expected);

            expected = false;

            myList.add("test");
            outputArrayList = myList.isEmpty();
            assertEquals(outputArrayList,expected);
        }

        @Test
        public void sizeTest()
        {
            int expectedSize = 2;
            int outputSize;
            List myList = new FunctionalLinkedList();
            myList.add("test");
            myList.add("test");
            outputSize = myList.size();
            assertEquals(outputSize,expectedSize);
        }

        @Test
        public void getTest() {

            ReturnObject myReturnObject = new ReturnObjectImpl();
            Object expected = ErrorMessage.EMPTY_STRUCTURE;
            Object output;

            //test that appropriate error message is returned when trying to get item from empty list
            List myList = new FunctionalLinkedList();
            myReturnObject = myList.get(1);
            output = myReturnObject.getError();
            assertEquals(output, expected);

            //test that appropriate error message is returned when trying to get item from non existent index
            expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
            myList.add("zero");
            myReturnObject = myList.get(-1);
            output = myReturnObject.getError();
            assertEquals(output, expected);

            myReturnObject = myList.get(2);
            output = myReturnObject.getError();
            assertEquals(output, expected);


            //test that correct item is returned
            myList.add("one");
            myList.add("two");
            expected = "two";
            myReturnObject = myList.get(2);
            output = myReturnObject.getReturnValue();
            assertEquals(output, expected);

        }

        @Test
        public void addEndListTest()
        {
            //test null object insertion scenario

            ReturnObject myReturnObject = new ReturnObjectImpl();
            Object expected = ErrorMessage.INVALID_ARGUMENT;
            Object output;
            List myList = new FunctionalLinkedList();
            myList.add("test");
            myReturnObject = myList.add(null);
            output = myReturnObject.getError();
            assertEquals(output, expected);

            //test legitimate item scenario

            expected = ErrorMessage.NO_ERROR;
            myReturnObject = myList.add("test");
            output = myReturnObject.getError();
            assertEquals(output, expected);

            //test boundary case when more items than original length on the list added

            List myShortList = new FunctionalLinkedList();
            myShortList.add("test");
            myShortList.add("test");
            myReturnObject = myShortList.add("test");
            output = myReturnObject.getError();
            assertEquals(output, expected);

        }
    @Test
    public void addTest()
    {
        ReturnObject myReturnObject = new ReturnObjectImpl();

        //test null object insertion scenario
        List myList = new FunctionalLinkedList();
        Object expected = ErrorMessage.INVALID_ARGUMENT;
        Object output;
        myList.add("zero");
        myList.add("two");
        myList.add("three");
        myReturnObject = myList.add(1,null);
        output = myReturnObject.getError();
        assertEquals(output, expected);

        //test trying to insert using -ve index
        expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
        myReturnObject = myList.add(-3,"one");
        output = myReturnObject.getError();
        assertEquals(output, expected);

        //test trying to insert using index greater than the size of the list
        myReturnObject = myList.add(4,"one");
        output = null; //clear previous output to make sure it is not left over from previous test
        output = myReturnObject.getError();
        assertEquals(output, expected);

        //test legitimate input and make sure that elements at and after that position updated accordingly
        expected = "two";
        myList.add(1,"one");
        myReturnObject = myList.get(2);
        output = myReturnObject.getReturnValue();
        assertEquals(output, expected);
        expected = "three";
        myReturnObject = myList.get(3);
        output = myReturnObject.getReturnValue();
        assertEquals(output, expected);
    }

        @Test
        public void removeTest() {

            ReturnObject myReturnObject = new ReturnObjectImpl();

            //test removal of item at -ve index
            List myList = new FunctionalLinkedList();
            Object expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
            Object output;
            myList.add("zero");
            myList.add("one");
            myList.add("two");
            myReturnObject = myList.remove(-2);
            output = myReturnObject.getError();
            assertEquals(output, expected);

            //test removal of item at index greater than the size of the list
            output = null;
            myReturnObject = null;
            myReturnObject = myList.remove(5);
            output = myReturnObject.getError();
            assertEquals(output, expected);

            //test removal of item at legitimate index and adjustment of
            //indeces of remaining elements accordingly
            output = null;
            expected = "one";
            myReturnObject = null;
            myReturnObject = myList.remove(1);
            output = myReturnObject.getReturnValue();
            assertEquals(output, expected);

            output = null;
            expected = "two";
            myReturnObject = null;
            myReturnObject = myList.get(1);
            output = myReturnObject.getReturnValue();
            assertEquals(output, expected);
        }
        @Test
        public void validIndexNullTest()
        {
            //test to ensure there is no null at valid position (between 0 and size -1) of the List

            ReturnObject myObject = new ReturnObjectImpl();
            List myList = new FunctionalLinkedList();
            myList.add("zero");
            myList.add("one");
            myList.add("two");
            int listSize;
            listSize = myList.size();

            for ( int i =0; i>listSize; i++)
            {
                myObject = myList.get(i);
                assertNotNull(myObject.getReturnValue());
            }
        }

        @Test
        public void headTest()
        {
            ReturnObject myObject = new ReturnObjectImpl();
            FunctionalLinkedList myList = new FunctionalLinkedList();
            Object expected;
            Object output;

            //test empty list scenario
            expected = ErrorMessage.EMPTY_STRUCTURE;
            myObject = myList.head();
            output = myObject.getError();
            assertEquals(output, expected);

            expected=null;
            myObject = null;
            myList.add("zero");
            myList.add("one");
            myList.add("two");
            expected = "zero";
            myObject = myList.head();
            output = myObject.getReturnValue();
            assertEquals(output, expected);
        }


        @Test
        public void restTest()
        {
            ReturnObject myObject = new ReturnObjectImpl();
            FunctionalLinkedList myList = new FunctionalLinkedList();
            Object expected;
            Object output;
            int myRestListSize;

            for (int i = 0; i < 15; i++)
            {
                myList.add(i);
            }

            FunctionalList myRestList = new FunctionalLinkedList();
            myRestList = myList.rest();
            myRestListSize = myRestList.size();

            for (int n = 0; n < myRestListSize; n++)
            {

                expected = myList.get(n + 1).getReturnValue();
                output = myRestList.get(n).getReturnValue();
                assertEquals(output, expected);
                expected = null;
                output = null;
            }
        }

}
