package List;

import Support.*;

public class FunctionalArrayList extends ArrayList implements FunctionalList {
    public ReturnObject head()
    {
        ReturnObject myObject = new ReturnObjectImpl();
        myObject = get(0);
        return myObject;
    }

    public FunctionalList rest()
    {
        FunctionalList myFunctionalList = new FunctionalArrayList();
        FunctionalList myFunctionalListCopy = new FunctionalArrayList();
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
