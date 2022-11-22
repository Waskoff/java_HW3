public class Record {
    long id;
    String phoneNumber;
    String name;

    public Record(long id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
