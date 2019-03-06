package investigation;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mengxi on 2019/2/20.
 */
public class ReadSkaarPackage {

    public static void main(String[] args) {
        List<File> fileList = fileList();
        Set<String> packageSet = new HashSet<>();
        fileList.stream().forEach(file -> {
            System.out.println(file.getName());
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String br = fileReader.readLine();
                while (br != null) {
                    String packageName = br.split("\\t")[2];
                    String addressName = packageName.split("\\?")[0];
                    packageSet.add(addressName);
                    br = fileReader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("发生了异常");
            }
        });

        System.out.println("end to read------------------------");
        packageSet.stream().filter(pack->pack.contains(".zip") && pack.contains("K0Q")).forEach(pack -> System.out.println(pack));
    }


    public static List<File> fileList() {
        File dFile = new File("C:\\Users\\mengxi\\mydata\\workspace\\ideaworkspace\\schedule\\src\\main\\webapp\\investigationfile");
        File[] fileList = dFile.listFiles();
        // Arrays.stream(fileList).forEach(file -> System.out.println(file.getName()));
        return Arrays.asList(fileList);
    }

}
