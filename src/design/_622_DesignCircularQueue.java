package design;

/**
 * @author Diyang Li
 * @create 2022-09-20 12:07 AM
 */
public class _622_DesignCircularQueue {
    int[] arr;
    int first;
    int last;
    int size;
    int k;

    public _622_DesignCircularQueue(int k) {
        arr = new int[k];
        first = 0;
        last = -1;
        size = 0;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            last = (last+1) % k;
            arr[last] = value;
            size++;
            return true;
        }
    }

    // like pop() of queue
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            first = (first + 1)% k;
            size--;
            return true;
        }
    }

    public int Front() {
        return isEmpty()? -1: arr[first];
    }

    public int Rear() {
        return isEmpty()? -1: arr[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
