public class NewUserRes {   // new response to be consumed in my SomeService

    String name;
    Integer age;

    String address;

    Integer pin;

    Integer cell;

    public NewUserRes(String name, Integer age, String address, Integer pin, Integer cell) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.pin = pin;
        this.cell = cell;
    }

     public String getName() {
        return name;
    }
}
