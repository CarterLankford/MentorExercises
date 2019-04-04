public class Node {
    private Node next;
    private int payload;

    public Node(int payload, Node nextNode){
        setPayload(payload);
        setNext(nextNode);
    }

    public Node getNext(){
        return next;
    }

    public int getPayload(){
        return payload;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setPayload(int payload){
        this.payload = payload;
    }

    public Node withPayload(int payload){
        return next;
    } 

    public Node withNext(Node next){
        return next;
    }
}