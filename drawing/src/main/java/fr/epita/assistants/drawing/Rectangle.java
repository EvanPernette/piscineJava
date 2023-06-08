package fr.epita.assistants.drawing;


public class Rectangle extends Sharp{
    private int width;
    private int length;
    
    public Rectangle(int width, int length){
        super(width);
        this.width = width;
        this.length = length;
    }
    
    @Override
    public void draw(){
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                if(i == 0 || i == this.length - 1 || j == 0 || j == this.width - 1){
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}