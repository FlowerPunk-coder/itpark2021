package lesson29.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@ShellComponent
@RequiredArgsConstructor
public class ZipArch {

    private final static String DOT_ZIP = ".zip";
    private String fullPath = "";


    @ShellMethod(value = "File to zip", key = {"f", "fileToZip"})
    public void fileToZip(@ShellOption({"-n, --name"}) File name) {
        this.fullPath = name.getParent() + DOT_ZIP;
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(this.fullPath))) {

            try (FileInputStream fis = new FileInputStream(name)) {
                ZipEntry zipEntry = new ZipEntry(name.getName());
                zos.putNextEntry(zipEntry);
                byte[] allBytes = new byte[fis.available()];
                fis.read(allBytes);
                zos.write(allBytes);
                zos.closeEntry();
            }
            System.out.printf("Архивация файла прошла успешно. Запакованный файл находится в %s\n", this.fullPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @ShellMethod(value = "Directory to zip", key = {"dir", "directory"})
    private void dirToZip(@ShellOption({"-d, --dir"}) File dir) {
        this.fullPath = dir + DOT_ZIP;
        try (ZipOutputStream z = new ZipOutputStream(new FileOutputStream(this.fullPath))) {
            File[] allFiles = dir.listFiles();
            if (allFiles != null) {
                Arrays.stream(allFiles).forEach(e -> {
                    try {
                        FileInputStream f = new FileInputStream(e);
                        byte[] temp = new byte[f.available()];
                        ZipEntry zip = new ZipEntry(e.getName());
                        z.putNextEntry(zip);
                        f.read(temp);
                        z.write(temp);
                        f.close();
                        z.closeEntry();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                System.out.printf("Архивация прошла успешно, запакованные файлы находятся в %s\n", this.fullPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(value = "Unzip", key = {"u", "unzip"})
    private void unzip(@ShellOption({"-f, --funzip"}) String fileZip) {
        File dir = new File(fileZip);
        File newDir = new File(dir.getParent() + "\\Unzip");
        if (!newDir.exists()) {
            newDir.mkdir();
        }
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip))){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();
                FileOutputStream f = new FileOutputStream(newDir + "\\" + name);
                while (zis.available() > 0) {
                    f.write(zis.read());
                }
                f.flush();
                zis.closeEntry();
                f.close();
            }
            System.out.printf("Разархивация прошла успешно, распакованные файлы находятся в %s\n", newDir.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }


}
