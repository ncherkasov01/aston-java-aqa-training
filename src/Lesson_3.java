import java.util.Scanner;

public class Lesson_3 {
    //task 1 solution
    public static class Animal {
        static int countAnimal = 0;

        Animal() {
            countAnimal++;
        }

        void run(int range) {
            System.out.println("Животное пробежало " + range + " м.");
        }

        void swim(int range) {
            System.out.println("Животное пробежало " + range + " м.");
        }

        public static int getCountAnimal() {
            return countAnimal;
        }
    }

    public static class Cat extends Animal {
        String name;
        static int countCat = 0;
        int appetite;
        boolean fullness;

        Cat(String name, int appetite, boolean fullness) {
            super();
            countCat++;
            this.name = name;
            this.appetite = appetite;
            this.fullness = fullness;
        }

        void eat(Bowl b) {
            b.decreaseFood(appetite);
        }

        public static class Bowl {
            public int food;

            public Bowl(int food) {
                this.food = food;
            }

            public void decreaseFood(int n) {
                food -= n;
            }

            public void increaseFood(int x) {
                food += x;
            }

            public void info() {
                System.out.println("Всего еды: " + food);
            }
        }

        @Override
        void run(int range) {
            if (range > 200) {
                System.out.println(name + " кот не может пробежать более 200 м.");
            } else {
                System.out.println(name + " пробежал " + range + " м.");
            }
        }

        @Override
        void swim(int range) {
            System.out.println(name + " не умеет плавать");
        }

        static int getCountCat() {
            return countCat;
        }

    }

    public static class Dog extends Animal {
        String name;
        static int countDod = 0;

        Dog(String name) {
            super();
            countDod++;
            this.name = name;
        }

        @Override
        void run(int range) {
            if (range > 500) {
                System.out.println(name + " не может пробежать более 500 м.");
            } else {
                System.out.println(name + " пробежала " + range + " м.");
            }

        }

        @Override
        void swim(int range) {
            if (range > 10) {
                System.out.println(name + " не может проблыть больше " + range + " м.");
            } else {
                System.out.println(name + " проплыла" + range + " м.");
            }
        }

        static int getCountDod() {
            return countDod;
        }
    }

    public static Scanner sc = new Scanner(System.in);

    //task 2 solution
    public interface Shape {
        double calculatePerimeter();

        double calculateArea();
    }

    public interface Fillable {
        void setFillColor(String color);
    }

    public interface Borderable {
        void setBorderColor(String color);
    }

    public static class Circle implements Shape, Fillable, Borderable {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        public void printCharacteristics() {
            System.out.println("Circle:");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill color: " + fillColor);
            System.out.println("Border color: " + borderColor);
        }
    }

    public static class Rectangle implements Shape, Fillable, Borderable {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        public void printCharacteristics() {
            System.out.println("Rectangle:");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill color: " + fillColor);
            System.out.println("Border color: " + borderColor);
        }
    }

    public static class Triangle implements Shape, Fillable, Borderable {
        private double side1;
        private double side2;
        private double side3;
        private String fillColor;
        private String borderColor;

        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        @Override
        public double calculatePerimeter() {
            return side1 + side2 + side3;
        }

        @Override
        public double calculateArea() {
            double halfPerimeter = calculatePerimeter() / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        public void printCharacteristics() {
            System.out.println("Triangle:");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill color: " + fillColor);
            System.out.println("Border color: " + borderColor);
        }
    }

    public static void main(String[] args) {
        //task 1
        Animal pig = new Animal();
        Animal lion = new Animal();

        Cat kotenok = new Cat("Котёнок", 100, false);
        Dog bobik = new Dog("Бобик");
        kotenok.run(100);
        kotenok.run(201);
        kotenok.swim(100);

        bobik.run(300);
        bobik.run(501);
        bobik.swim(100);
        bobik.swim(5);
        System.out.println("Всего животных создано " + Animal.getCountAnimal());
        System.out.println("Всего котов: " + Cat.getCountCat());
        System.out.println("Всего собак: " + Dog.getCountDod());

        int action;
        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Барсик", 5, false);
        allCats[1] = new Cat("Снежок", 30, false);
        allCats[2] = new Cat("Мурзик", 10, false);
        allCats[3] = new Cat("Чернышка", 45, false);

        Cat.Bowl bowl = new Cat.Bowl(100);
        bowl.info();
        for (int i = 0; i < allCats.length; i++) {
            if (allCats[i].fullness == false && allCats[i].appetite < bowl.food) {
                allCats[i].eat(bowl);
                allCats[i].fullness = true;
                System.out.println("Котик " + allCats[i].name + " покушал!");
            } else {
                System.out.println("Котик " + allCats[i].name + " не поел!");
            }
        }
        bowl.info();
        System.out.println("Сколько грамм вискаса добавить еще в миску?");
        action = sc.nextInt();
        bowl.increaseFood(action);
        bowl.info();

        //task 2
        Circle circle = new Circle(5);
        circle.setFillColor("Red");
        circle.setBorderColor("Black");
        circle.printCharacteristics();

        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.setFillColor("Blue");
        rectangle.setBorderColor("Green");
        rectangle.printCharacteristics();

        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("Yellow");
        triangle.setBorderColor("Orange");
        triangle.printCharacteristics();
    }
}
