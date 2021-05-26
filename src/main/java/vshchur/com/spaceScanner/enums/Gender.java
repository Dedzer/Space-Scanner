package vshchur.com.spaceScanner.enums;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int databaseKey;

    Gender(int databaseKey) {
        this.databaseKey = databaseKey;
    }

    public int getDatabaseKey() {
        return databaseKey;
    }

    public Gender fromDatabaseKey(int key) {
        for (Gender gender : Gender.values()) {
            if (gender.databaseKey == key) {
                return gender;
            }
        }
        return null;
    }
}
