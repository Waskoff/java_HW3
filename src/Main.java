public class Main {
    public static void main(String[] args) {
        Record record1 = new Record(1, "+79139498268", "Edward");
        Record record2 = new Record(2, "+79529361732", "Alexey");
        Record record2again = new Record(2, "+79529361732", "Alexey");
        Record record3 = new Record(3, "+79139051601", "Maksim");
        Record record4 = new Record(4, "+79134569182", "Kirill");
        Record record4updated = new Record(4, "+79134569182", "Кирилл");
        Record record4wrong = new Record(4, null, "Kirilla");
        Record record5 = new Record(5, "+88005553535", "Money");

        PhoneBook myPhoneBook = new PhoneBook();
        //Действие 1
        System.out.println("Действие 1");
        //Заполним телефонную книжку людьми и подконец попробуем добавить уже существующую запись
        try {
            myPhoneBook.createRecord(record1);
            myPhoneBook.createRecord(record2);
            myPhoneBook.createRecord(record3);
            myPhoneBook.createRecord(record4);
            myPhoneBook.createRecord(record2again);

        } catch (PhoneNumberAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        //выведем записную книжку
        System.out.println(myPhoneBook.getAllRecords());

        //Действие 2
        System.out.println("\nДействие 2");
        //перепишем Кириллу имя на русском и попытаемся изменить запись которой не существует
        try {
            myPhoneBook.updateRecord(record4updated);
            myPhoneBook.updateRecord(record5);
        } catch (RecordNotValidException | RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //выведем записную книжку
        System.out.println(myPhoneBook.getAllRecords());

        //Действие 3
        System.out.println("\nДействие 3");
        //попробуем поменять на запись с отсутствующим номером телефона
        try {
            myPhoneBook.updateRecord(record4wrong);
        } catch (RecordNotValidException | RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Действие 4
        System.out.println("\nДействие 4");
        //удалим запись с кириллом, а так же попробуем удалить не сущестующую запись
        try {
            myPhoneBook.deleteRecord(4);
            myPhoneBook.deleteRecord(5);
        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //выведем записную книжку
        System.out.println(myPhoneBook.getAllRecords());
    }
}