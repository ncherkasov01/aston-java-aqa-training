public class Lesson_2 {
    //task 1 solution
    public static class Employee {

        private String firstName;
        private String lastName;
        private String middleName;
        private String jobTitle;
        private String email;
        private int mobileNumber;
        private int salary;
        private int age;

        public Employee(String firstName, String lastName, String middleName, String jobTitle, String email, int mobileNumber, int salary, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.jobTitle = jobTitle;
            this.email = email;
            this.mobileNumber = mobileNumber;
            this.salary = salary;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{"
                    + "firstName='" + firstName + '\''
                    + "lastName='" + lastName + '\''
                    + "middleName='" + middleName + '\''
                    + "jobTitle='" + jobTitle + '\''
                    + "email='" + email + '\''
                    + "mobileNumber='" + mobileNumber + '\''
                    + ", salary=" + salary + '\''
                    + ", age=" + age
                    + '}';
        }

        public void showMeEmployee() {
            System.out.println(this);
        }
    }
    //task 3 solution
    public static class Park {
        private String name;
        private String location;

        public Park(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public class ParkDescribtion {
            private String attractionName;
            private String workTime;
            private int cost;

            public ParkDescribtion(String attractionName, String workTime, int cost) {
                this.attractionName = attractionName;
                this.workTime = workTime;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Park{"
                        + "name='" + name + '\''
                        + "location='" + location + '\''
                        + "attractionName='" + attractionName + '\''
                        + "workTime='" + workTime + '\''
                        + "cost='" + cost + '\''
                        + '}';
            }
        }
    }

    public static void main(String[] args) {
        //task 2 solution
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivan", "Petrov", "Ivanovich", "QA", "test@test.com", +712345678, 25000, 20);
        empArray[1] = new Employee("Petr", "Chaikovskyi", "Ilich", "Composer", "music@music.com", +111111111, 10000000, 100);
        empArray[2] = new Employee("Jack", "Black", "Noot", "Singer", "jack@music.com", +1948304847, 30000000, 50);
        empArray[3] = new Employee("Steve", "Jobs", "Apple", "Head of Apple", "Apple@Apple.com", +1000000000, 300000, 60);
        empArray[4] = new Employee("Bill", "Gates", "Windows", "ex Windows manager", "windows@windows.com", +2342342, 100500, 55);

        empArray[4].showMeEmployee();

        //task 3
        Park sokol = new Park("sokol", "Moscow");
        Park.ParkDescribtion sokolDescribtion = sokol.new ParkDescribtion("koleso", "9to6", 100);
        System.out.println(sokolDescribtion);
    }
}