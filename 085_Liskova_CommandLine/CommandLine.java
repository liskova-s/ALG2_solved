/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandline;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 *
 * @author sarka
 */
public class CommandLine {

    private File homeDir;
    private File actualDir;
    private boolean endtrue = false;

    public CommandLine() {
        homeDir = new File(System.getProperty("user.dir"));
        actualDir = homeDir;
    }

    public String getPath() {
        return actualDir.getAbsolutePath();
    }

    /*
    private String arrayToStringFolderFile(File[] a) {
        StringBuilder sb = new StringBuilder();
        for (File element : a) {
            if (element.isDirectory()) {
                sb.append(element).append("\n");
            }
        }
        for (File element
                : a) {
            {
                if (element.isFile()) {
                    sb.append(element.getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String dir(String[] parts) {
        if (parts.length == 1) {
            File[] subFoldersFiles = actualDir.listFiles();
            return arrayToStringFolderFile(subFoldersFiles);
        } else {
            if (parts[1].equals("-e")) {//dir -e .txt
                String[] subFoldersFiles = actualDir.list(new ExtensionFilter(parts[1]));//filtruje soubory s koncovkou .txt
                return Arrays.toString(subFoldersFiles);
            }
            return null;
        }
    }
     */
    public String parseAndExecute(String command) throws IOException {
        String[] parsed = command.trim().split(" ");
        switch (parsed[0]) {
            case "-mkfile":
                if (parsed.length < 2) {
                    return "ERR: Can not operate without filename.";
                }
                return mkfile(parsed[1]);
            case "-help":
                return help();
            case "-h":
                return help();
            case "-dir":
                if (parsed.length < 2) {
                    return dir();
                }
                return dir(parsed[1]);
            case "-exit":
                endtrue = true;
                break;
            case "-e":
                endtrue = true;
                break;
            case "-cd":
                if (parsed.length < 2) {
                    return "ERR: Can not operate without directory name.";
                }
                return cdIn(parsed[1]);

            case "-cd..":
                cdOut();
                break;
            case "-mkdir":
                if (parsed.length < 2) {
                    return "ERR: Can not operate without directory name.";
                }
                return mkdir(parsed[1]);
            case "-mkdirs":
                if (parsed.length < 2) {
                    return "ERR: Can not operate without path input.";
                }
                return mkdirs(parsed[1]);
            case "-rename":
                if (parsed.length < 3) {
                    return rename(parsed[1], parsed[2]);
                }
                return "ERR: Can not operate without name input.";
            case "-del":
                if (parsed.length < 2) {
                    return "ERR: Can not operate without filename.";
                }
                return delete(parsed[1]);
            case "-map":
                return map();
            default:
                return "Invalid input";
        }
        return "";
    }

    private String mkfile(String filename) throws IOException {
        //File f = new File(actualDir.getAbsoluteFile()+File.separator+filename);
        //f.createNewFile();
        //File f = new File(parentaldirectory, filename);
        File f = new File(actualDir, filename);
        //f.createNewFile(); //throws exception musi byt osetrena - bud try catch, nebo posli o jedno nahoru
        if (f.createNewFile()) {
            return "File successfully created.";
        } else {
            return "File already exists.";
        }
    }

    private String help() {
        return ("HELP\n"
                + "-h   -help               show this help message\n"
                + "-e   -exit               exit command line\n"
                + "-dir                     returns list of content in current directory\n"
                + "-dir <dir_name>          returns list of content in <dir_name> directory\n"
                + "-cd <directory>          change directory: enter <directory> \n"
                + "-cd..                    change directory: return to parent directory \n"
                + "-mkfile <file_name>      creates file <file_name> in current directory\n"
                + "-mkdir <dir_name>        creates a new directory <dir_name>\n"
                + "-mkdirs <path>           creates directories specified in <path>\n"
                + "-rename <nm1> <nm2>      renames file or directory <nm1> to <nm2>\n"
                + "-map                     shows directory map - startpoint: current directory\n"
                + "-del <filename>          delete file <filename>\n");

    }

    private String dir() {
        String[] contentList;
        StringBuilder sb = new StringBuilder();
        contentList = actualDir.list();
        for (String line : contentList) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    private String dir(String dirname) {
        String[] contentList;
        StringBuilder sb = new StringBuilder();
        File d = new File(actualDir, dirname);
        if (d.exists()) {
            contentList = d.list();
        } else {
            return "No such directory found.";
        }
        for (String line : contentList) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    private String cdIn(String dirname) {
        File d = new File(actualDir.getAbsolutePath(), dirname);
        if (d.isDirectory()) {
            actualDir = d;
            return "";
        } else {
            return "No such directory found.";
        }
    }

    private void cdOut() {
        int chop = actualDir.getName().length() + 1;
        String actdirpath = actualDir.getAbsolutePath();
        String path = actdirpath.substring(0, actdirpath.length() - chop);
        actualDir = new File(path);
    }

    private String mkdir(String dirname) throws IOException {
        File d = new File(actualDir, dirname);
        if (d.mkdir()) {
            return "Directory successfully created.";
        } else {
            return "Directory already exists.";
        }
    }

    private String mkdirs(String pathway) throws IOException {
        int lastIndex = pathway.lastIndexOf(File.separator);
        String tocheck = pathway.substring(0, lastIndex);
        File d = new File(tocheck);
        if (d.isDirectory()) {
            File n = new File(pathway);
            if (n.mkdir()) {
                return "Directory successfully created.";
            } else {
                return "Directory already exists.";
            }
        }
        return "Invalid path.";
    }

    private String rename(String file1, String file2) {
        File name1 = new File(file1);
        File name2 = new File(file2);
        if (name1.exists()) {
            if (!name2.isFile()) {
                name1.renameTo(name2);
                return "Successfully renamed.";
            } else {
                return "File already exists.";
            }
        } else {
            return "File not found.";
        }
    }

    private String map() {
        StringBuilder sb = new StringBuilder();
        // File object
        File dir = new File(actualDir.getAbsolutePath());

        File arr[] = dir.listFiles();

        sb.append(dir.getName());
        sb.append(System.getProperty("line.separator"));

        sb.append(recursiveSearch(arr, 0));
        return sb.toString();
    }

    private StringBuilder recursiveSearch(File[] arr, int level) {
        StringBuilder sb = new StringBuilder();
        //main dir files
        for (File f : arr) {
            // tabs
            for (int i = 0; i <= level; i++) {
                sb.append("\t");
            }
            if (f.isFile()) {
                sb.append(f.getName());
                sb.append(System.getProperty("line.separator"));
            } else if (f.isDirectory()) {
                sb.append("[").append(f.getName()).append("]");
                sb.append(System.getProperty("line.separator"));

                // sub-dirs
                sb.append(recursiveSearch(f.listFiles(), level + 1));
            }
        }
        return sb;
    }

    private String delete(String filename) {
        File f = new File(actualDir, filename);
        if (f.delete()) {
            return "File deleted.";
        }
        return "File not found.";
    }

    public boolean EndTrue() {
        return endtrue;
    }

}
