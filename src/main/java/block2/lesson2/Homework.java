package block2.lesson2;

public class Homework {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        Render render = new Render();

        System.out.println("Building");

        Building building = new Building(100);
        building.setCurrentHealthPoint(90);

        render.showIndicator(building); // В консоли должно быть примерно так: Текущий уровень здоровья: 50, максимальный уровень здоровья: 100

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Hero");

        Hero hero = new Hero(100, 100);
        hero.setCurrentHealthPoint(50);
        hero.setCurrentManaPoint(50);

        render.showIndicator(hero);

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Neutral");

        Neutral neutral = new Neutral(90);
        neutral.setCurrentHealthPoint(15);

        render.showIndicator(neutral);

//        System.out.println(ANSI_RED + "This text has a red background but default text!" + ANSI_RESET);
//        System.out.println(ANSI_GREEN + "This text has a green background but default text!" + ANSI_RESET);




    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            if (object instanceof Health) {
                int maxHealth = ((Health) object).getMaxHealth();
                int curentHealth = ((Health) object).getCurrentHealth();
                int indicatorVolume = 10;
                int indicatorHealth = curentHealth * 100 / maxHealth / indicatorVolume;
                String color = Homework.ANSI_WHITE;
                String cororReset = Homework.ANSI_RESET;
                int greenBoundary = 7;
                int yellowBoundary = 3;

                if (indicatorHealth >= greenBoundary) {
                    color = Homework.ANSI_GREEN;
                } else if (indicatorHealth >= yellowBoundary) {
                    color = Homework.ANSI_YELLOW;
                } else {
                    color = Homework.ANSI_RED;
                }

                System.out.println("[" + color + new String(new char[indicatorHealth]).replace("\0", "x")
                        + new String(new char[indicatorVolume - indicatorHealth]).replace("\0", " ") +
                        cororReset + "]");
                System.out.println(color + "Текущий уровень здоровья: " + curentHealth +
                        ", максимальный уровень здоровья: " + maxHealth + cororReset);
            }
            if (object instanceof Mana) {
                int maxMana = ((Mana) object).getMaxMana();
                int currentMana = ((Mana) object).getCurentMana();
                int indicatorVolume = 10;
                int indicatorMana = currentMana * 100 / maxMana / indicatorVolume;
                String color = Homework.ANSI_WHITE;
                String cororReset = Homework.ANSI_RESET;
                int purpleBoundary = 7;
                int blueBoundary = 3;

                if (indicatorMana >= purpleBoundary) {
                    color = Homework.ANSI_PURPLE;
                } else if (indicatorMana >= blueBoundary) {
                    color = Homework.ANSI_BLUE;
                } else {
                    color = Homework.ANSI_CYAN;
                }

                System.out.println("[" + color + new String(new char[indicatorMana]).replace("\0", "x")
                        + new String(new char[indicatorVolume - indicatorMana]).replace("\0", " ") +
                        cororReset + "]");
                System.out.println(color + "Текущий уровень маны: " + currentMana +
                        ", максимальный уровень маны: " + maxMana + cororReset);
            }
        }

    }

    static class Building implements Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное

        @Override
        public int getMaxHealth() {
            return this.maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return this.currentHealthPoint;
        }
    }
    static class Hero implements Mana, Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        private int maxManaPoint; // максимально количество магический энергии
        private int currentManaPoint; // текущее количество магический энергии

        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное

        @Override
        public int getMaxHealth() {
            return this.maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return this.currentHealthPoint;
        }

        @Override
        public int getMaxMana() {
            return this.maxManaPoint;
        }

        @Override
        public int getCurentMana() {
            return this.currentManaPoint;
        }
    }

    static class Neutral implements Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное

        @Override
        public int getMaxHealth() {
            return this.maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return this.currentHealthPoint;
        }
    }

}
