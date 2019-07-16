public class Human implements People{
    public String greet(){
       return "Hi! I'm a human";
    }

    public String waveOff(){
        return "See you later!";
    }

    @Override
    public String speak(){
        return "I, a human, was asked to be creative";
    }
}