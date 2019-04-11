/**
 * This class provides two constructors: a parameterless and another one that takes a limit.
 */
public class DynamicStack implements Stack{
    private int numberOfNodes = 0;
    private Integer numberOfNodesLimit = null;
    private Node topNode = null;

    public DynamicStack() {

    }

    public DynamicStack(Integer numberOfNodesLimit){
        setNumberOfNodesLimit(numberOfNodesLimit);
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
        int tmpNode = topNode.getPayload();
        topNode = topNode.getNext();
        numberOfNodes--;
        return tmpNode;
    }

    @Override
    public int size(){
        return numberOfNodes;
    }

    @Override
    public boolean isFull(){
        if (null != numberOfNodesLimit && numberOfNodes >= numberOfNodesLimit){
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
    public Integer getNumberOfNodesLimit(){
        return numberOfNodesLimit;
    }

    //only want this set when constructed
    private void setNumberOfNodesLimit(Integer numberOfNodesLimit){
        this.numberOfNodesLimit = numberOfNodesLimit;
    }
}