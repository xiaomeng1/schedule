package investigation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by mengxi on 2019/2/25.
 */
public class FileRecordCompare {


    public static void main(String[] args) throws Exception {
        String newPath = "C:\\Users\\mengxi\\mydata\\workspace\\ideaworkspace\\schedule\\src\\main\\webapp\\investigationfile\\cpt_lost_record_complete.txt";
        String oldPath = "C:\\Users\\mengxi\\mydata\\workspace\\ideaworkspace\\schedule\\src\\main\\webapp\\investigationfile\\cpt_lost_multi.txt";

        Set<String> newList = readDataRecordToSet(newPath);
        Set<String> oldList = readDataRecordToSet(oldPath);


        newList.removeAll(oldList);

        System.out.println("set record size is " + newList.size());
        //newList.stream().forEach(record -> System.out.println(record));

//        Map<String, Integer> proMap = readDataRecord(proPath);
//        Map<String, Integer> devMap = readDataRecord(devPath);
//
//        List<String> validPath = new ArrayList<>();
//        List<String> inValidPath = new ArrayList<>();
//
//        proMap.entrySet().forEach(entry -> {
//            Integer proCount = entry.getValue();
//            Integer devCount = devMap.get(entry.getKey());
//
//            if (devCount.equals(proCount) || devCount < proCount) {
//                validPath.add(entry.getKey());
//                System.out.println("key:" + entry.getKey() + "   val:" + entry.getValue());
//            } else {
//                inValidPath.add(entry.getKey());
//            }
//        });


//        devMap.entrySet().forEach(entry -> {
//            Integer devCount = entry.getValue();
//            Integer proCount = proMap.get(entry.getKey());
//
//            if (devCount.equals(proCount)) {
//                validPath.add(entry.getKey());
//                System.out.println("key:" + entry.getKey() + "   val:" + entry.getValue());
//            } else if(devCount > proCount) {
//                inValidPath.add(entry.getKey());
//            }
//        });
//        System.out.println("不合法的包数量为：" + inValidPath.size());
//        System.out.println("合法的包数量为：" + validPath.size());
    }


    public static List<String> readDataRecordToList(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        List list = new ArrayList<>();
        String br = fileReader.readLine();
        while (br != null) {
            list.add(br.trim());
            br = fileReader.readLine();
        }

        return list;
    }


    public static Set<String> readDataRecordToSet(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        Set<String> recordSet = new HashSet<>();
        String br = fileReader.readLine();
        while (br != null) {
            recordSet.add(br.trim());
            br = fileReader.readLine();
        }

        return recordSet;
    }


    public static Map<String, Integer> readDataRecord(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        Map<String, Integer> map = new HashMap<>();
        String br = fileReader.readLine();
        while (br != null) {
            String[] array = br.split("\\t");
            map.put(array[0], Integer.parseInt(array[1]));
            br = fileReader.readLine();
        }

        return map;
    }
}
