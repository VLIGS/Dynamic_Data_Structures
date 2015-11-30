package List;
import Support.*;

public class LinkedList implements List
{
    private ObjectNode myFirstObject;
    private int items;
    public LinkedList()
    {
        myFirstObject=null;
        items = 0;
    }
    public boolean isEmpty()
    {
        if (myFirstObject==null)
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
            int count = 0;
            ObjectNode myNode = myFirstObject;
            while (count!=index)
            {
                myNode = myNode.getNext();
                count++;
            }
            myObject.setMyObject(myNode.getObject());
        }
        return myObject;
    }

    /**
     * Method to validate that index provided to update List is valid
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error is returned.
     * @param index the position at which List is to be updated
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
        ReturnObjectImpl myObject = new ReturnObjectImpl();

        if(isEmpty())
        {
            myObject.setErrorMessage(ErrorMessage.EMPTY_STRUCTURE);
        }
        else if (validateIndex(index,myObject))
        {
            int count = 0;

            ObjectNode myCurrentNode = myFirstObject;
            ObjectNode myPreviousNode=null;

            while (count!=index)
            {
                myPreviousNode = myCurrentNode;
                myCurrentNode = myCurrentNode.getNext();
                count++;
            }
            myObject.setMyObject(myCurrentNode.getObject());
            if (index ==0)
            {
                //if removing first item in the list
                myFirstObject = myCurrentNode.getNext();
            }
            else if (myCurrentNode.getNext()==null)
            {
                //if removing last item in the list
                myPreviousNode.setNext(null);
            }
            else
            {
                myPreviousNode.setNext(myCurrentNode.getNext());
            }
            items--;
        }
        return myObject;
    }

    public ReturnObject add(int index, Object item)
    {
        ReturnObjectImpl myObject = new ReturnObjectImpl();
        if (validateIndex(index,myObject))
        {
            if (item != null)
            {
                if(isEmpty()|| index==items)
                {
                    add(item);
                }
                else if(index==0)
                {
                    ObjectNode newObject = new ObjectNode(item);
                    newObject.setNext(myFirstObject);
                    myFirstObject=newObject;
                    items++;
                }
                else
                {
                    int count = 0;
                    ObjectNode myCurrentNode = myFirstObject;
                    ObjectNode myPreviousNode = null;

                    while (count!=index)
                    {
                        myPreviousNode = myCurrentNode;
                        myCurrentNode = myCurrentNode.getNext();
                        count++;
                    }
                    ObjectNode newObject = new ObjectNode(item);
                    myPreviousNode.setNext(newObject);
                    newObject.setNext(myCurrentNode);
                    items++;
                }
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
            ObjectNode newObject = new ObjectNode(item);
            if(isEmpty())
            {
                myFirstObject=newObject;
            }
            else
            {
                ObjectNode anotherObject = myFirstObject;
                while(anotherObject.getNext()!=null) {
                    anotherObject = anotherObject.getNext();
                }
                anotherObject.setNext(newObject);
            }
            items++;
        }
        else
        {
            myObject.setErrorMessage(ErrorMessage.INVALID_ARGUMENT);
        }
        return myObject;
    }
}
