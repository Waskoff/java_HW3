import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneBook {
    private List<Record> AllRecords = new ArrayList<>();

    public void setListOfRecords(List<Record> listOfRecords) {
        this.AllRecords = listOfRecords;
    }
    public List<Record> getAllRecords() {
        return AllRecords;
//        for (Record eachRecord : AllRecords) {
//            Record.printRecord(eachRecord);
//        }
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExistsException {
        //метод сохраняет в справочнике новую запись. Если в справочнике есть запись с
        //таким же номером телефона, выбросить проверяемое исключение PhoneNumberAlreadyExists.
        for (Record eachRecord : AllRecords) {
            if (Objects.equals(record.phoneNumber, eachRecord.phoneNumber)) {
                throw new PhoneNumberAlreadyExistsException("PhoneNumberAlreadyExistsException, в справочнике есть запись с таким же номером телефона");
            }
        }
        AllRecords.add(record);
    }

    public void updateRecord(Record record) throws RecordNotValidException, RecordNotFoundException {
        //метод обновляет запись в справочнике. Если запись с таким идентификатором
        //не существует, выбросить непроверяемое исключение RecordNotFound. Если в новой записи не заполнено поле name и/или
        //поле phoneNumber, выбросить проверяемое исключение RecordNotValid
        int flag = 0;
        if (record.name == null || record.phoneNumber == null || record.phoneNumber.isEmpty() || record.name.isEmpty()) {
            throw new RecordNotValidException("RecordNotValidException, поля name и/или phoneNumber не заполненны");
        }
        for (Record eachRecord : AllRecords) {
            if (Objects.equals(record.id, eachRecord.id)) {
                AllRecords.set((int) (eachRecord.id - 1), record);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new RecordNotFoundException("RecordNotFoundException, запись с таким идентификатором не существует");
        }
    }

    public void deleteRecord(long id) throws RecordNotFoundException {
//    удаляет запись из справочника по идентификатору, если подходящая запись в
//    справочнике не найдена - выбрасывается непроверяемое исключение RecordNotFound
        int flag = 0;
        for (Record eachRecord : AllRecords) {
            if (Objects.equals(id, eachRecord.id)) {
                AllRecords.remove(eachRecord);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new RecordNotFoundException("RecordNotFoundException, запись с таким идентификатором не существует");
        }
    }
}
