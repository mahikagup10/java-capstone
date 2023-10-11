class Main{
    int a;
    int b;
    int c;
    public Main()
    {
        System.out.println("This is a constructor");
        a = 10;
        b = 20;
    }

    void addnums(int x, int y)
    {
        a = x;
        b = y;
        c = a+b;
        System.out.println("The new value of c is" + c);
    }

    public static void main()
    {
        System.out.println("This is the main function");
        Main obj = new Main();


        System.out.println("Value of a,b,c = " + a + ","+ b +"," +c);
        obj.addnums(30, 40);
    }
}
