class Department {
    private String id;
    private String name;
    private String establishmentDate;

    public Department(String id, String name, String establishmentDate) {
        this.id = id;
        this.name = name;
        this.establishmentDate = establishmentDate;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }
}
