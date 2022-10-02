package homeWorkJUnit;

public enum Cities {
    MOW("Москва"), SPE("Санкт-Петербург"), NVS("Новосибирск");

    private final String city;

    Cities(String city) {
        this.city = city;
    }

    public String getCity(){ return city; }

}
