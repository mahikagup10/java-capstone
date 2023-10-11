import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceSimulator {

    public static void main(String[] args) {
        int numRunners = 5;
        if (args.length > 0) {
            numRunners = Integer.parseInt(args[0]);
        }

        List<Runner> runners = new ArrayList<>();

        for (int i = 0; i < numRunners; i++) {
            Runner runner = new Runner("Runner " + (i+1));
            runners.add(runner);
            runner.start();
        }

        boolean finished = false;
        while (!finished) {
            for (Runner runner : runners) {
                System.out.println(runner.getName() + ": " + runner.getDistance() + " meters");

                if (runner.getDistance() >= 1000) {
                    runner.setFinished(true);
                    finished = true;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        runners.sort((r1, r2) -> r2.getDistance() - r1.getDistance());

        System.out.println("\nTop 3 Runners:");
        for (int i = 0; i < 3; i++) {
            Runner runner = runners.get(i);
            System.out.println(runner.getName() + ": " + runner.getDistance() + " meters");
        }
    }

    static class Runner extends Thread {
        private final String name;
        private int distance = 0;
        private boolean finished = false;

        public Runner(String name) {
            this.name = name;
        }

        public void run() {
            Random rand = new Random();
            while (!finished) {
                int meters = rand.nextInt(6) + 5;
                distance += meters;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }
    }
}
