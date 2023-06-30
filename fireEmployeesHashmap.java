import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.*;


class Main{
    public static String[] fireEmployees(String[] employees, String[] unemployed){
        Map<String, String> unemployedMap = new HashMap<>();
        ArrayList<String>  keptEmployees = new ArrayList<>();
        for (int i = 0; i < unemployed.length; i++){
            unemployedMap.put(unemployed[i], unemployed[i]);
        }

        for (int j = 0; j < employees.length; j++){
            if (unemployedMap.get(employees[j]) == null) keptEmployees.add(employees[j]);
        }

        // converting ArrayList<String> to String[]
        Function<ArrayList<String>, String[]> toArray = dArr -> dArr.toArray(new String[0]);

        return toArray.apply(keptEmployees);
    }

    public static void pirntStrArr(String[] strArr){
        if (strArr.length == 0){
            System.out.println("[]");
            return;
        }

        String output = "";
        for (int i = 0; i < strArr.length; i++){
            output += ", " + strArr[i];
        }

        System.out.println("[" + output.substring(2) + "]");
        
    }

    public static void main(String[] args){
        String[] employees1 = {"Steve","David","Mike","Donald","Lake","Julian"};
        String[] unemployed1 = {"Donald","Lake"};
        String[] employees2 = {"Donald","Lake"};
        String[] unemployed2 = {"Donald","Lake"};
        String[] employees3 = {"Steve","David","Mike","Donald","Lake","Julian"};
        String[] unemployed3 = {};

        pirntStrArr(fireEmployees(employees1, unemployed1));
        pirntStrArr(fireEmployees(employees2, unemployed2));
        pirntStrArr(fireEmployees(employees3, unemployed3));
    }
}

