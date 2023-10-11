public abstract class figure {
    double dim1;
    double dim2;
    figure(double a, double b){
        dim1 = a;
        dim2 = b;
    }
    abstract double findArea();
}

class Rectangle extends figure{
    
    double findArea()
    {
        return dim1*dim2;
    }

    public static void main(String[] args)
    {
        Rectangle obj = new Rectangle();
        
        
    }
}
