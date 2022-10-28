class Bird {
    private String name;
    static private int numBird = 0;

    Bird(String Name) {
        this.name = Name;
        numBird++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getNum() {
        return numBird;
    }

    public static void main(String[] argv) {
        Bird bird1 = new Bird("1");
        Chicken chicken1 = new Chicken("2");
        Chicken chicken2 = new Chicken("3");
        Penguin penguin1 = new Penguin("4");
        Penguin penguin2 = new Penguin("5");
        Penguin penguin3 = new Penguin("6");

        System.out.println("numBird = " + Bird.getNum());
        System.out.println("numChicken = " + Chicken.getNum());
        System.out.println("numPenguin = " + Penguin.getNum());
    }
}

