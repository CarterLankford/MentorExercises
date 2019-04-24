public class Node {
    private Node next;
    private int payload;

    public Node(){

    }

    public Node(int payload, Node nextNode){
        setPayload(payload);
        setNext(nextNode);
    }

    public Node getNext(){
        Node topNode = next;
        setNext(null);
        return topNode;
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
        this.payload = payload;
        return this;
    }

    public Node withNext(Node node){
        this.next = node;
        return this;
    }
}