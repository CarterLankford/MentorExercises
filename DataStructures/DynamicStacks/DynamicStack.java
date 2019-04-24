/**
 * This class provides two constructors: a parameterless and another one that takes a limit.
 */
public class DynamicStack implements Stack{
    private int numberOfNodes = 0;
    private Integer limit = null;
    private Node topNode = null;

    public DynamicStack() {

    }

    public DynamicStack(Integer limit){
        setLimit(limit);
    }

    @Override
    public boolean push(int payload){
        if(!isFull()){
            Node nd = new Node(payload, topNode);
            topNode = nd;
            this.numberOfNodes++;
            return true;
        }
        return false;        
    } 

    @Override
    public Integer peek(){
        if (isEmpty()){
            return null;
        }
        return topNode.getPayload();
    }

    @Override
    public Integer pop(){
        if(isEmpty()){
            System.out.println("No node found");
            return null;
        }

        Node tempTopNode = topNode; //use temp value to allow modification of current node
        topNode = topNode.getNext(); //set class variable to next node
        tempTopNode.setNext(null); //clearning reference
        numberOfNodes--;
        return tempTopNode.getPayload();
    }

    @Override
    public int size(){
        return numberOfNodes;
    }

    @Override
    public boolean isFull(){
        if (null != limit && numberOfNodes >= limit){
            System.out.println("Max node count reached");
            return true;            
        }
        return false;
    }

    @Override
    public boolean isEmpty(){
        return numberOfNodes == 0;
    }

    // Want to be able to view this at any point
    public Integer getLimit(){
        return limit;
    }

    //only want this set when constructed
    private void setLimit(Integer limit){
        this.limit = limit;
    }
}