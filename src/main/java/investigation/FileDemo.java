package investigation;

import java.io.File;

/**
 * Created by mengxi on 2019/2/25.
 */
public class FileDemo {

    public static void main(String[] args) {
        //System.out.println(renameInNotSamePartition());
        System.out.println(renameInNotSamePartition());
    }


    public static boolean renameInSamePartition() {
        File sourceFile = new File("C:\\tmp\\source.txt");
        File target = new File("C:\\tmp\\target.txt");
        return sourceFile.renameTo(target);
    }


    public static boolean renameInNotSamePartition() {
        File sourceFile = new File("C:\\tmp\\source.txt");
        File target = new File("D:\\tmp\\target.txt");
        return sourceFile.renameTo(target);
    }


    public static boolean newIssure() {
        int a = 10;

        return true;
    }
}
