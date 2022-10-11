package Exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//  Создание списка записей
        ArrayList<Record> records = new ArrayList();
        records.add(new Record(101, "12", "Иван"));
        records.add(new Record(102, "12", "Алекс"));
        records.add(new Record(103, "4", "Марк"));
        PhoneBook phoneBook = new PhoneBook();
        for (Record rec : records) {
            try {
                phoneBook.createRecord(rec);
            } catch (PhoneNumberAlreadyExists e) {
                System.out.println(rec +" не добавлена. В справочнике уже есть запись с номером телефона " + rec.getPhoneNumber());
            }
        }
//  Вывод списка всех записей
        System.out.println(phoneBook.getAllRecords());
//  Вызов непроверяемого исключения при удалении несуществуещей записи
//        phoneBook.deleteRecord(111);

//  Удаление существующей записи
        phoneBook.deleteRecord(103);
        System.out.println(phoneBook.getAllRecords());

        try {
//  Вызов непроверяемого исключения при изменении несуществуещей записи
//            phoneBook.updateRecord(new Record(102, "12", "B"));
//  Изменение данных записи
            phoneBook.updateRecord(new Record(101,"5", "A"));
//  Вызов проверяемого исключения при изменении записи с внесением неполных данных
//            phoneBook.updateRecord(new Record(101, null, null));
//            phoneBook.updateRecord(new Record(101, null, "B"));
            phoneBook.updateRecord(new Record(101, "1234567", null));
        } catch (RecordNotValid e) {
            System.out.println(e.getMessage()+". Данные не будут обновлены.");
        }
        System.out.println(phoneBook.getAllRecords());
    }
}

