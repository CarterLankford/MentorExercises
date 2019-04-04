public class DynamicStack implements Stack{
    //TODO: 
    // Add two constructors: parameterless and with parameter that takes a limit
    // If no limit is set, isFull will return false always, 
    // otherwise it will check the current size vs the limit
    // Add getter and setter for max nodes
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
        //TODO: Add logic
        if (numberOfNodesLimit != null){
            if (numberOfNodesLimit <= numberOfNodes) {
                System.out.println("Max node count reached");
                return true;
            }            
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