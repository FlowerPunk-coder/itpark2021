package lesson29.shell;

import lesson29.service.LocalizationService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@ShellComponent
public class ZipArch {

    private final static String DOT_ZIP = ".zip";
    private String fullPath = "";
    private final LocalizationService localizationService;

    public ZipArch(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }


    @ShellMethod(value = "File to zip", key = {"f", "fileToZip"})
    public String fileToZip(@ShellOption({"-n, --name"}) File name) {
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
            return localizationService.localize("zip.text", this.fullPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";

    }

    @ShellMethod(value = "Directory to zip", key = {"dir", "directory"})
    private String dirToZip(@ShellOption({"-d, --dir"}) File dir) {
        this.fullPath = dir + DOT_ZIP;
        try (ZipOutputStream z = new ZipOutputStream(new FileOutputStream(this.fullPath))) {
            File[] allFiles = dir.listFiles();
            if (allFiles != null) {
                Arrays.stream(allFiles).forEach(e -> {
                    try (FileInputStream f = new FileInputStream(e)) {
                        byte[] temp = new byte[f.available()];
                        ZipEntry zip = new ZipEntry(e.getName());
                        z.putNextEntry(zip);
                        f.read(temp);
                        z.write(temp);
                        z.closeEntry();
                    }  catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                return localizationService.localize("zip.text", this.fullPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @ShellMethod(value = "Unzip", key = {"u", "unzip"})
    private String unzip(@ShellOption({"-f, --funzip"}) String fileZip) {
        File dir = new File(fileZip);
        File newDir = new File(dir.getParent() + "\\Unzip");
        if (!newDir.exists()) {
            newDir.mkdir();
        }
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();
                try (FileOutputStream f = new FileOutputStream(newDir + "\\" + name)) {
                    while (zis.available() > 0) {
                        f.write(zis.read());
                    }
                    f.flush();
                    zis.closeEntry();
                }
            }
            return localizationService.localize("unzip.text", newDir.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
