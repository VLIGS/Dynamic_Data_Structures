package List;

public class SampleableListImpl extends ArrayList implements SampleableList
{
    public SampleableList sample()
    {
        SampleableList myList = new SampleableListImpl();
        int mySize;
        mySize = size();
        for (int i = 1; i< mySize; i+=2)
        {
            myList.add(this.get(i).getReturnValue());
        }
        return myList;
    }
}
