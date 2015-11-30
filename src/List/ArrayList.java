package List;
import Support.*;

public class ArrayList implements List
{
    private Object [] myArrayList;

    /**
     * items field is introduced to keep track of non null items in the list.
     * It allows to make implementation of size()method more efficient
     * removing any need to loop through ArrayList until first null is encountered
     * in order to discover the size of ArrayList
     */

    private int items;

    /**
     * List is initialise to default size 10. Once size reaches originally initialised it will be
     * extended by doubling each time list is full
     */

    public ArrayList()
    {
        myArrayList = new Object[10];
        items = 0;
    }


    public boolean isEmpty()
    {
        if(items==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int size()
    {
        return items;
    }

    public ReturnObject get(int index)
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();

        if(isEmpty())
        {
            myObject.setErrorMessage(ErrorMessage.EMPTY_STRUCTURE);
        }
        else if (validateIndex(index,myObject))
        {
            myObject.setMyObject(myArrayList[index]);
        }
        return myObject;
    }

    /**
     * Method to validate that index provided to update ArrayList is valid
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error is returned.
     * @param index the position at which ArrayList is to be updated
     * @param myObject ReturnObjectImpl that will record error message if index is not valid
     * @return true if index is valid and false otherwise
     */
    private boolean validateIndex(int index, ReturnObjectImpl myObject)
    {
        if(index==0)
        {
            return true;
        }
        else if (index>items-1||index <0)
        {
            myObject.setErrorMessage(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return false;
        }
        else
        {
            return true;
        }
    }

    public ReturnObject remove(int index)
    {
        ReturnObject myObject = new ReturnObjectImpl();
        myObject = get(index);
        if(!myObject.hasError()) {
            shift(index, -1);
            myArrayList[items - 1] = null;
            items--;
        }
        return myObject;
    }

    public ReturnObject add(int index, Object item)
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();
        if (validateIndex(index,myObject))
        {
            if (item !=null)
            {
                if(items==myArrayList.length)
                {
                    growMyArray();
                }
                if(index!=items)
                {
                    shift(index,1);
                }
                myArrayList[index]=item;
                items++;
            }
            else
            {
                myObject.setErrorMessage(ErrorMessage.INVALID_ARGUMENT);
            }
        }
        return myObject;
    }

    public ReturnObject add(Object item)
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();
        if (item !=null)
        {
            if (items == myArrayList.length)
            {
                growMyArray();
            }
            myArrayList[items] = item;
            items++;
        }
        else
        {
            myObject.setErrorMessage(ErrorMessage.INVALID_ARGUMENT);
        }
        return myObject;
    }

    /**
     * doubles size of myArrayList once it is full
     */
    private void growMyArray()
    {
        Object [] myNewArrayList = new Object [myArrayList.length*2];
        for( int i = 0; i<=items-1; i++)
        {
            myNewArrayList[i]=myArrayList[i];
        }
        myArrayList=myNewArrayList;
    }

    /**
     * shift items in ArrayList stepSize places starting from specified index in array
     *
     * @param fromIndex index from which shift starts
     * @param stepSize if -ve shift items forward reducing number of non null items
     *                 if +ve shift items back to create space for more non null items
     *                 can shift more than 1 step and therefore create or remove space
     *                 for more than 1 item to allow more flexibility if specifications
     *                 change in future
     */
    private void shift(int fromIndex, int stepSize)
    {
        if (stepSize>0)
        {
            for (int i = items-1; i >= fromIndex; i--)
            {
                myArrayList[i+stepSize] = myArrayList[i];
            }
        }
        else
        {
            for (int i = fromIndex; i < items-fromIndex; i++)
            {
                myArrayList[i] = myArrayList[i + stepSize*-1];
            }
        }
    }

}
