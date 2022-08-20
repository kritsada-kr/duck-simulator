import Factories.AbstractDuckFactory;
import Factories.CountAndEchoDuckFactory;
import Factories.CountingDuckFactory;
import Factories.DuckFactory;
import adaptors.GooseAdapter;
import adaptors.PigeonAdapter;
import animals.*;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.quackquack();

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

    private void quackquack(){
        Quackable mallardDuck = new MallardDuck();
        Quackable redHeadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);

        System.out.println("----------------------------");

        Quackable mallardDuck1 = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck1 = new QuackCounter(new RedheadDuck());
        Quackable duckCall1 = new QuackCounter(new DuckCall());
        Quackable rubberDuck1 = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter1 = new GooseAdapter(new Goose());
        Quackable pigeonAdapter1 = new PigeonAdapter(new Pigeon());
        Quackable mallardDecorator = new QuackCounter(new QuackEcho(new MallardDuck()));
        System.out.println("\nDuck Simulator: With Decorator");
        simulate(mallardDuck1);
        simulate(redHeadDuck1);
        simulate(duckCall1);
        simulate(rubberDuck1);
        simulate(gooseAdapter1);
        simulate(pigeonAdapter1);
        simulate(mallardDecorator);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");

        System.out.println("----------------------------");

        Quackable mallardDuck2 = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck2 = new QuackCounter(new RedheadDuck());
        Quackable duckCall2 = new QuackCounter(new DuckCall());
        Quackable rubberDuck2 = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter2 = new GooseAdapter(new Goose());
        Quackable pigeonAdapter2 = new PigeonAdapter(new Pigeon());
        Quackable redHeadDecorator2 = new QuackEcho(new QuackCounter(new RedheadDuck()));
        System.out.println("\nDuck Simulator: With Decorator");
        simulate(mallardDuck2);
        simulate(redHeadDuck2);
        simulate(duckCall2);
        simulate(rubberDuck2);
        simulate(gooseAdapter2);
        simulate(pigeonAdapter2);
        simulate(redHeadDecorator2);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");

        System.out.println("----------------------------");

        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoDuckFactory();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable redHeadDuck3 = countingDuckFactory.createRedheadDuck();
        Quackable duckCall3 = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck3 = countAndEchoDuckFactory.createRubberDuck();
        System.out.println("\nDuck Simulator: With Abstract Factory");
        simulate(mallardDuck3);
        simulate(redHeadDuck3);
        simulate(duckCall3);
        simulate(rubberDuck3);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");

        System.out.println("----------------------------");

        AbstractDuckFactory duckFactory2 = new DuckFactory();
        AbstractDuckFactory countingDuckFactory2 = new CountingDuckFactory();
        Quackable mallardDuck4 = duckFactory2.createMallardDuck();
        Quackable redHeadDuck4 = duckFactory2.createRedheadDuck();
        Quackable duckCall4 = countingDuckFactory2.createDuckCall();
        Quackable rubberDuck4 = countingDuckFactory2.createRubberDuck();
        Flock flock = new Flock();
        flock.add(mallardDuck4);
        flock.add(redHeadDuck4);
        flock.add(duckCall4);
        flock.add(rubberDuck4);
        flock.quack();

        System.out.println("----------------------------");

        AbstractDuckFactory duckFactory3 = new DuckFactory();
        AbstractDuckFactory countingDuckFactory3 = new CountingDuckFactory();
        Quackable mallardDuck5 = duckFactory3.createMallardDuck();
        Quackable redHeadDuck5 = duckFactory3.createRedheadDuck();
        Quackable duckCall5 = countingDuckFactory3.createDuckCall();
        Quackable rubberDuck5 = countingDuckFactory3.createRubberDuck();
        FlockWithAlpha flock2 = new FlockWithAlpha();
        flock2.add(mallardDuck5);
        flock2.add(redHeadDuck5);
        flock2.add(duckCall5);
        flock2.add(rubberDuck5);
        flock2.quack();
    }





}
