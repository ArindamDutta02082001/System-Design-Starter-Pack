
// we create adapters of the new Service not the Old service  **vvi

public class USERADAPTER implements INewUserService {

    IOldUserService IOldUserService;

    // **vvi
    // we embed the old service
    // as we fetch the old data and pass via adapter to the new service

    USERADAPTER( IOldUserService IOldUserService)
    {
        this.IOldUserService = IOldUserService;
    }

    @Override
    public NewUserRes fetchUserNew() {

        OldUser oldUser = IOldUserService.fetchUser();  // fetch old data

        // convert old data to new data MAPPPER is used generally   **vvi

        NewUserRes newUserRes = new NewUserRes(oldUser.getName(), oldUser.getAge() , "" , 00 , 00 );

        return newUserRes;  // return new data
    }
}
