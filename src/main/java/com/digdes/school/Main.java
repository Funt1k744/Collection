package com.digdes.school;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        JavaSchoolStarter starter = new JavaSchoolStarter();
        try {
            //Вставка строки в коллекцию
            List<Map<String,Object>> result1 = starter.execute("INSERT VALUES 'lastName' = 'Федоров' , 'id'=1, 'age'=40, 'active'=true");
            List<Map<String,Object>> result2 = starter.execute("INSERT VALUES 'lastName' = 'Артем' , 'id'=2, 'age'=20, 'active'=true");
            //Изменение значения которое выше записывали
            List<Map<String,Object>> result3 = starter.execute("UPDATE VALUES 'active'=false, 'cost'=10.1");
            //Получение всех данных из коллекции
            List<Map<String,Object>> result4 = starter.execute("SELECT");
            System.out.println(result4);
            //Удаление записи
            List<Map<String,Object>> result5 = starter.execute("DELETE");
            //Получение всех данных из коллекции
            List<Map<String,Object>> result6 = starter.execute("SELECT");
            System.out.println(result4);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}