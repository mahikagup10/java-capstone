class P{
    protected int x = 10;
    public int y = 20;
    private int z = 30;

}
    

class inheritance extends P{
    int a = 40;
    public static void main(String args[])
    {
        inheritance obj = new inheritance();
        System.out.println(obj.x);
        System.out.println(obj.y);
        //System.out.println(obj.z);
        System.out.println(obj.a);
    }
}
