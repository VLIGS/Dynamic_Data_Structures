package Stack;

import Support.*;
import List.*;

public class ImprovedStackImpl implements ImprovedStack
{
    private StackImpl myStack;
    public ImprovedStackImpl()
    {
        List myList = new LinkedList();
        myStack = new StackImpl(myList);
    }

    public boolean isEmpty()
    {
        return myStack.isEmpty();
    }

    public int size()
    {
        return myStack.size();
    }

    public void push(Object item)
    {
        myStack.push(item);
    }


    public ReturnObject top()
    {
        return myStack.top();
    }

    public ReturnObject pop()
    {
        return myStack.pop();
    }

    public ImprovedStack reverse()
    {
        ImprovedStack myReversedStack = new ImprovedStackImpl();
        int mySize = this.size();
        if (mySize==1)
        {
            myReversedStack.push(myStack.top().getReturnValue());
        }
        else{
            for (int i = 0; i<mySize;i++)
            {
                myReversedStack.push(myStack.internalList.get(i).getReturnValue());
            }
        }
        return myReversedStack;
    }

    public void remove(Object object)
    {
        ImprovedStack myUpdatedStack = new ImprovedStackImpl();
        int mySize = this.size();
        Object myObject;
        for (int i = 0; i<mySize;i++)
        {
            myObject = this.myStack.pop().getReturnValue();
            if (!myObject.equals(object))
            {
                myUpdatedStack.push(myObject);
            }
        }
        mySize = myUpdatedStack.size();
        for (int n = 0; n<mySize;n++)
        {
            this.myStack.push(myUpdatedStack.pop().getReturnValue());
        }
    }
}
