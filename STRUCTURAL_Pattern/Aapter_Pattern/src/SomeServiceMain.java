
class SomeServiceMain {
    public static void main(String[] args) {


        /**
         *    GOAL
         *    Two systems need to talk to each other
         *    but their interfaces do not match.
         *
         * Adapter is NOT mainly for:
         *
         * “I used old service before, now I want new service.”
         * That’s migration. you delete the old file and use the new file simple !!
         *
         * Adapter is mainly for:
         * “Two systems must work together but their interfaces don’t match.”
         * you keep both files with you and create adapter file to make them work together !!
         *
         */


             // SomeService accepts NewUserRes but we have only OldUserService which gives us OldUser data

            IOldUserService oldUserService = new OldUserServiceImpl();

            USERADAPTER userAdapter = new USERADAPTER(oldUserService);  // adapter

             NewUserRes newUserRes = userAdapter.fetchUserNew();

             System.out.println(newUserRes.getName());






    }

}
