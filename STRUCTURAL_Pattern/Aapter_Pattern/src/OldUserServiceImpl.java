class OldUserServiceImpl implements IOldUserService {

    @Override
    public OldUser fetchUser() {
        return new OldUser("John Doe", 30);
    }
}
