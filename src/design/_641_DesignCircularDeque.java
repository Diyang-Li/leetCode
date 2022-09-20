package design;

/**
 * @author Diyang Li
 * @create 2022-09-20 10:36 AM
 */
public class _641_DesignCircularDeque {
    int[] arr;
    int k;
    int size;
    int front;
    int rear;
    public _641_DesignCircularDeque(int k) {
        arr = new int[k];
        size = 0;
        front = 0;
        rear = -1;
        this.k = k;
    }

    // the front move left
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else{
            if(front == 0){
                front = k;
            }
            front--;
            arr[front] = value;
            size++;
            // coner case, if don't do this, if we only add from front, then the rear will always be -1;
            if(size == 1) rear = front;
            return true;
        }
    }
    // the rear move right
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else{
            rear = (rear+1)%k;
            arr[rear] = value;
            size++;
            return true;
        }
    }
    //-1 0 1 2 k=3
    //   1 2 3
    //     f
    //   r
    //size = 2

    // fron move right
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else{
            front = (front+1)%k;
            // if(size == 1){
            //     rear = front;
            // }
            size--;
            return true;
        }
    }
    //rear move left
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else{
            if(rear == 0){
                rear = k;
            }
            rear = (rear-1)%k;
            size--;
            return true;
        }
    }

    public int getFront() {
        return isEmpty()?-1:arr[front];
    }

    public int getRear() {
        return isEmpty()?-1:arr[rear];
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public boolean isFull() {
        return size == k;
    }
}
