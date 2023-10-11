public class SUBLIT-1 {
    
}


import java.util.Scanner;

public class Myclass{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n ; i++){
            String[] p = in.nextLine().split(" ");
            Animal a;
            if(p[0].equals("LION")){
                a = new Lion(p[1],Integer.parseInt(p[2]));
                if(p[3].equals("SPEAK")){
                    a.speak();
                }
                else if(p[3].equals("SLEEP")){
                    a.sleep();
                }
            }
            else if(p[0].equals("MONKEY")){
                a = new Monkey(p[1]);
                if(p[2].equals("SPEAK")){
                    a.speak();
                }
                else if(p[2].equals("SLEEP")){
                    a.sleep();
                }
            }
            else if(p[0].equals("ELEPHANT")){
                a = new Elephant(p[1],Integer.parseInt(p[2]));
                if(p[3].equals("SPEAK")){
                    a.speak();
                }
                else if(p[3].equals("SLEEP")){
                    a.sleep();
                }
            }
        }
        in.close();
    }
}

abstract class Animal{
    String name;

    public Animal(String name)
    {
        this.name = name;
        // super();
    }

    void sleep(){
        System.out.println("\n"+name +" is sleeping");
    }

    //abstract void speak(String a, int b);
    abstract void speak();
}

class Lion extends Animal{

    int speed;

    Lion(String name,int speed){
        super(name);
        this.speed = speed;
    }
    @Override
    void sleep(){
        System.out.println("\n"+name+"is sleeping");
    }

    void speak(){
        System.out.println("\n"+"I am a lion, my name is"+name+"and I am"+speed+"m/s fast");
    }

}

class Monkey extends Animal{

    Monkey(String name){
        super(name);
    }
    @Override
    void sleep(){
        System.out.println("\n"+name+"is sleeping");
    }

    void speak(){
        System.out.println("\n"+"I am a monkey, my name is"+name);

    }
}

class Elephant extends Animal{
    
    int weight;

    Elephant(String name,int weight){
        super(name);
        this.weight = weight;
    }

    @Override
    void speak(){
        System.out.println("\n"+"I am an elephant, my name is"+name+"and I weigh"+weight+"kgs");

    }

}


