package Stack;

import List.*;
import Support.*;

public class StackImpl extends AbstractStack
{
        public StackImpl(List list)
        {
            super (list);
        }
        public boolean isEmpty()
        {
            if (this.internalList.isEmpty())
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
            return this.internalList.size();
        }

        public void push(Object item)
        {
            if (item !=null)
            {
               this.internalList.add(0,item);
            }
        }

        public ReturnObject top()
        {
            ReturnObject myObject = new ReturnObjectImpl();
            myObject = internalList.get(0);
            return myObject;
        }

        public ReturnObject pop()
        {
            ReturnObject myObject = new ReturnObjectImpl();
            myObject = internalList.remove(0);
            return myObject;
        }

}
