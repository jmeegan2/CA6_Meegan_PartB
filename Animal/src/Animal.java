class RoboHunter implements Predator {

    //method eat(Prey prey)
    //Override the method in Predator interface
    public void eat(Prey prey) {
        System.out.println("RoboHunter has killed the prey up with a laser");
    }

    //Method hunt(Prey prey)
    //Override the method in Predator Interface
    //Hunt is always successful for RoboHunters
    public boolean hunt(Prey prey) {
        System.out.println(this.toString() + " is hunting the" + prey.toString());
        return true;
    }

    //toString method
    @Override
    public String toString() {
        return "RoboHunter";
    }

}

//Bait
//Implements Prey
class Bait implements Prey {
    /**
     * overriding nutrition() method
     * of Prey interface
     * nutrition is always zero for Baits
     */
    public int nutrition() {
        return 0;
    }

    /**
     * toString() Method
     */
    @Override
    public String toString() {
        return "Bait";
    }
}

/**
 * interface Predator
 */
interface Predator {

    /**
     * abstract method eat(Prey prey)
     */
    void eat(Prey prey);

    /**
     * abstract method hunt(Prey prey)
     */
    boolean hunt(Prey prey);
}

/**
 * interface Prey
 */
interface Prey {

    /**
     * abstract method nutrition()
     */
    int nutrition();

    /**
     * abstract class Animal
     */
    public abstract class Animal {

        /**
         * instance variable
         * int health
         */
        private int health;

        /**
         * getter method for
         * int health
         */
        public int getHealth() {
            return health;
        }

        /**
         * setter method for
         * int health
         */
        public void setHealth(int health) {
            this.health = health;
        }
    }

    /**
     * class Snake
     * extends Animal
     * implements Prey
     */
    class Snake extends Animal implements Prey {

        /**
         * overriding nutrition method
         * of Prey
         */
        public int nutrition() {
            if (super.getHealth() > 2)
                return 3;
            else
                return 1;
        }

        /**
         * overriding toString method
         */
        @Override
        public String toString() {
            return "Snake";
        }
    }


    /**
     * class Bear
     * extends Animal
     * implements Predator, Prey
     */
    class Bear extends Animal implements Predator, Prey {

        /**
         * overriding eat method
         * of Predator
         */
        public void eat(Prey prey) {
            System.out.println("Bear is eating the " + prey.toString());

        }

        /**
         * overriding hunt method
         * of Predator
         */
        public boolean hunt(Prey prey) {
            if (prey.nutrition() > 5) {
                System.out.println("Bear couldn't hunt the " + prey.toString());
                return false;
            }
            System.out.println("Bear is hunting the " + prey.toString());
            return true;
        }

        /**
         * overriding nutrition method
         * of Prey
         */
        public int nutrition() {
            if (super.getHealth() > 5)
                return 12;
            else
                return 4;
        }

        /**
         * overriding toString method
         */
        @Override
        public String toString() {
            return "Bear";
        }
    }


    /**
     * class Falcon
     * extends Animal
     * implements Predator, Flying
     */
    class Falcon extends Animal implements Predator, Flying {

        /**
         * overriding hunt method of
         * Predator interface
         */
        public boolean hunt(Prey prey) {
            if (prey.nutrition() < 10) {
                System.out.println("Falcon is hunting the " + prey.toString());
                return true;
            }
            System.out.println("Falcon couldn't hunt the " + prey.toString());
            return false;
        }

        /**
         * overriding eat method
         * of Predator interface
         */
        public void eat(Prey prey) {
            if (prey.nutrition() > 5)
                System.out.println("Falcon is eating the " + prey.toString());
            else
                System.out.println("Falcon is not eating the " + prey.toString() + " as it has less nutrition");
        }

        /**
         * overriding fly method
         * of Flying interface
         */
        public void fly() {
            System.out.println("Falcon is flying");
        }

        /**
         * overriding toString method
         */
        @Override
        public String toString() {
            return "Falcon";
        }
    }


    /**
     * interface Flying
     */
    interface Flying {

        /**
         * abstract method fly
         */
        void fly();
    }


    /**
     * class Woodpecker
     * extends Animal
     * implements Flying
     */
    class Woodpecker extends Animal implements Flying {

        /**
         * overriding fly method of
         * Flying interface
         */
        public void fly() {
            System.out.println("Woodpecker is flying");
        }
    }


    /**
     * Main class
     */
    class Main {
        /**
         * main method
         */
        public static void main(String[] args) {

            Bait baitOne = new Bait();
            Bait baitTwo = new Bait();
            Bear bear = new Bear();
            bear.setHealth(5);
            Snake snake = new Snake();
            snake.setHealth(3);
            Prey[] preys = {baitOne, baitTwo, bear, snake};

            RoboHunter roboHunterOne = new RoboHunter();
            RoboHunter roboHunterTwo = new RoboHunter();
            Falcon falcon = new Falcon();
            falcon.setHealth(20);
            Predator[] predators = {roboHunterOne, roboHunterTwo, falcon, bear};

            for (Predator predator : predators) {
                for (Prey prey : preys) {
                    nature(predator, prey);
                }
            }

            Woodpecker woodpecker = new Woodpecker();
            isFlying(woodpecker);
            isFlying(falcon);
        }

        /**
         * nature(Predator predator, Prey prey)
         * this method takes in predator and prey instances
         * the predator hunts the prey in this method
         * the predator eats the prey if the hunt is successful
         */
        public static void nature(Predator predator, Prey prey) {
            if (predator.hunt(prey)) {
                predator.eat(prey);
            }

        }

        public static void isFlying(Flying flying) {
            flying.fly();
        }
    }
}