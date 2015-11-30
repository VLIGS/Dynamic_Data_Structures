package Support;

public class ReturnObjectImpl implements ReturnObject
{
    private Object myObject = new Object();
    private ErrorMessage myErrorMessage;
    private boolean myErrorFlag = false;

    public boolean hasError()
    {
        if (!myErrorFlag)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public ErrorMessage getError()
    {
        if (!hasError())
        {
            return ErrorMessage.NO_ERROR;
        }
        else
        {
            return myErrorMessage;
        }
    }
    public Object getReturnValue()
    {
        if(hasError())
        {
            return null;
        }
        else return myObject;
    }
    public void setErrorMessage(ErrorMessage myErrorMessage)
    {
        myErrorFlag = true;
        this.myErrorMessage = myErrorMessage;
    }
    public void setMyObject (Object myObject)
    {
        this.myObject = myObject;
    }
}
