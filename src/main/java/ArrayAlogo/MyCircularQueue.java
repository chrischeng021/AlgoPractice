package ArrayAlogo;

public class MyCircularQueue {
    private int[] _data;
    private int _headCursor;
    private int _tailCursor;
    private int _count;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        _data = new int[k];
        _headCursor = 0;
        _tailCursor = 0;
        _count = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(_count >= _data.length)
            return false;

        if(_tailCursor >= 0  && _tailCursor < _data.length){
            _data[_tailCursor++] = value;
            _count++;
            return true;
        }

        if(_headCursor >= 0 && _headCursor < _data.length){
            _data[_headCursor--] = value;
            _count++;
            return true;
        }

        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(_count == 0)
            return false;

        if(_headCursor < _tailCursor && _tailCursor <= _data.length){
            _data[_headCursor++] = Integer.MIN_VALUE;
            _count--;
            return true;
        }

        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        int element = -1;
        try{
            if(null != _data && _count > 0 && _headCursor < _data.length && _headCursor < _tailCursor) {
                element = _data[_headCursor] == Integer.MIN_VALUE ? -1 : _data[_headCursor];
            }
        }
        catch(NullPointerException e){
        }
        return element;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        int element = -1;
        try{
            if(null != _data && _count > 0 && _tailCursor <= _data.length) {
                element = _data[_tailCursor - 1];
            }
        }
        catch(NullPointerException e){
        }
        return element;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return  _count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return  _data.length == _count;
    }
}