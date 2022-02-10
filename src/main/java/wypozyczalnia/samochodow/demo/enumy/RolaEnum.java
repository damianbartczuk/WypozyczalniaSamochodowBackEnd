package wypozyczalnia.samochodow.demo.enumy;

import lombok.Getter;

@Getter
public enum RolaEnum {
    MANAGER("1", "manager"),
    ADMIN("2", "admin");

    private String id;
    private String nazwa;

    RolaEnum(String id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
}
