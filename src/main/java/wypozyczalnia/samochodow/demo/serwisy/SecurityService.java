package wypozyczalnia.samochodow.demo.serwisy;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
