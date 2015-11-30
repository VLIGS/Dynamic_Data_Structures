package Support;

public class ObjectNode {
    private Object myObject;
    private ObjectNode next;

    public ObjectNode (Object newObject)
    {
        myObject = newObject;
        next = null;
    }

    public Object getObject() {
        return myObject;
    }

    public ObjectNode getNext() {
        return next;
    }

    public void setNext(ObjectNode n) {
        this.next = n;
    }
    public void setObjectToNull()
    {
        this.myObject = null;
    }
}
