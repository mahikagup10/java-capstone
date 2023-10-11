import java.util.*;

public class Run {
    public static void main(String args[]) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of runners:");
        int n = in.nextInt(); 
        List<Runner> runners = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            runners.add(new Runner("Runner " + i));
        }

        for (Runner runner : runners) {
            runner.start();
        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            Collections.sort(runners);
            for (int i = 0; i < runners.size(); i++) {
                Runner runner = runners.get(i);
                System.out.println(runner.getName() + " has run " + runner.getDistance() + " m");
                if (runner.getDistance() >= 1000) {
                    System.out.println(runner.getName() + " has finished the race!\n");

                    for (int k = 0; k < runners.size(); k++) {
                        runner = runners.get(k);
                        if(runner.getDistance()<1000){
                            System.out.println(runner.getName() + " has run " + runner.getDistance() + " m");
                        }
                        
                    }
                    
                    System.out.println("\nThe top 3 runners are:");
                    for (int j = 0; j < 3; j++) {
                        System.out.println((j + 1) + ". " + runners.get(j).getName());
                    }
                    return;
                }
                runner.addDistance(new Random().nextInt(100) + 5);
            }
        }
       
    }
}

class Runner extends Thread implements Comparable<Runner> {
    private int distance;
    private String name;

    public Runner(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int compareTo(Runner other) {
        return Integer.compare(other.getDistance(), this.getDistance());
    }

    @Override
    public String toString() {
        return name;
    }
}
