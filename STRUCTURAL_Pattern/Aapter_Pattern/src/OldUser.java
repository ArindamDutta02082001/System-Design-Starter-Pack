public class OldUser {   // old format returned by oldUserService

    String name;
    Integer age;

    public OldUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

     public String getName() {
        return name;
    }

     public Integer getAge() {
        return age;
    }
}
