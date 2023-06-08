package fr.epita.assistants.drawing;

public class Triangle extends Sharp{
    private int length;
    
    public Triangle(int length){
        super(length);
        this.length = length;
    }
    
    @Override
    public void draw(){
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.length; j++){
                if( j == 0 || i == this.length - 1 || i == j){
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
    
