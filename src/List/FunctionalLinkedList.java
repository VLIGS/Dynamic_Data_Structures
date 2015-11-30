package List;

import Support.*;

public class FunctionalLinkedList extends LinkedList implements FunctionalList
{

    public ReturnObject head()
    {
        ReturnObject myObject = new ReturnObjectImpl();
        myObject = get(0);
        return myObject;
    }

    public FunctionalList rest()
        {
            FunctionalList myFunctionalList = new FunctionalLinkedList();
            FunctionalList myFunctionalListCopy = new FunctionalLinkedList();
            int mySize = myFunctionalList.size();
            if (mySize >1)
            {
                for (int i = 1; i<mySize; i++)
                {
                    myFunctionalListCopy.add(myFunctionalList.get(i));
                }
            }

            return myFunctionalListCopy;
        }
}
