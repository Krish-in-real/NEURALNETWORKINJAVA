public class ShapeExpection extends Exception {
    
    ShapeExpection(String Message){
        super(Message);
    }


    @Override
    public String toString() {
        return "ShapeExpection";
    }
    
}
