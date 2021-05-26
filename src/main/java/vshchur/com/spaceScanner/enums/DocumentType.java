package vshchur.com.spaceScanner.enums;

public enum DocumentType {

    PASSPORT(0), ID_CARD(1);

    private final int databaseKey;

    DocumentType(int databaseKey) {
        this.databaseKey = databaseKey;
    }

    public int getDatabaseKey() {
        return databaseKey;
    }

    public DocumentType fromDatabaseKey(int key) {
        for (DocumentType documentType : DocumentType.values()) {
            if (documentType.databaseKey == key) {
                return documentType;
            }
        }
        return null;
    }
}
