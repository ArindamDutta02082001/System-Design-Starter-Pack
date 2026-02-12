
class User
{
    public String name;
    public String email;

    // you can add getters here and make teh fields private


    public User( Builder builder)
    {
        this.name = builder.name;
        this.email = builder.email;
    }

    // create a static class Builder
    static class Builder
    {
        private String name;
        private String email;

//            public Builder()   // not required
//            {}

//        public static Builder builder() {   if you dont want to use new keyword
//            return new Builder();
//        }

        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }
        public Builder setEmail(String email)
        {
            this.email = email;
            return this;
        }


        // return the main class object
        public User build()
        {
            return new User(this);
        }

    }
}



public class Builder {



    public static  void main(String[] args) {

        // Get the constructed product
        User user = new User.Builder().setEmail("a@mail.com").build();
        System.out.println("user name : " + user.name + ", email: " + user.email);
    }
}
