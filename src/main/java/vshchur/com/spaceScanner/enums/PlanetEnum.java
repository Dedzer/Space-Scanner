package vshchur.com.spaceScanner.enums;

public enum PlanetEnum {
    MC(1),
    VN(2),
    ER(3),
    MR(4),
    JP(5),
    ST(6),
    UR(7),
    NT(8);

    private final int databaseKey;

    PlanetEnum(int databaseKey) {
        this.databaseKey = databaseKey;
    }

    public int getDatabaseKey() {
        return databaseKey;
    }

    public PlanetEnum fromDatabaseKey(int key) {
        for (PlanetEnum planetEnum : PlanetEnum.values()) {
            if (planetEnum.databaseKey == key) {
                return planetEnum;
            }
        }
        return null;
    }
}
