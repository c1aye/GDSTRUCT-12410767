public class ArrayQueue {
    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new Player[capacity];
        front = 0;
        back = 0;
    }

    public void enqueued(Player player){
        if (back == queue.length){
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, front, newQueue, 0, size());
            queue = newQueue;
            front = 0;
            back = size();
        }

        queue[back++] = player;
    }

    public Player dequeue() {
        if (size() == 0){
            return null;
        }

        Player removedPlayer = queue[front];
        queue[front++] = null;

        return removedPlayer;
    }

    public Player peek(){
        if(size() == 0){
            return null;
        }

        return queue[front];
    }

    public int size(){
        return back - front;
    }

    public void printQueue(){
        for (int i = front; i < back; i++){
            System.out.println(queue[i]);
        }
    }
}
