import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 3*. Подсчитать количество файлов в src.zip который находится в директории JDK
 */
public class Main {
    private static int countFilesInZip(ZipFile zipFile) {
        final Enumeration<? extends ZipEntry> entries = zipFile.entries();
        int numRegularFiles = 0;
        while (entries.hasMoreElements()) {
            if (!entries.nextElement().isDirectory()) {
                numRegularFiles++;
            }
        }
        return numRegularFiles;
    }

    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        File needFile = new File(javaHome + "/lib/src.zip");
        try {
            ZipFile zipFile = new ZipFile(needFile);
//            ZipFile zipFile = new ZipFile(new File("D:/test.zip"));
            System.out.println(countFilesInZip(zipFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
