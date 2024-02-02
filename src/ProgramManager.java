package managers;

import IO.FileHandler;
import exception.InvalidArgumentException;
import service.*;
import util.InputValidation;

public class ProgramManager {
    private static final int COMMAND_ARGUMENT_POSITION = 0;
    private static final int FILE_PATH_ARGUMENT_POSITION = 1;
    private static final int KEY_ARGUMENT_POSITION = 2;

    public void execute(String[] args, String command, String path, String key) {
        InputValidation inputValidation = new InputValidation();
        inputValidation.validate(args, command, path, key);

        FileHandler fileHandler = new FileHandler();
        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        BruteForceService bruteForceService = new BruteForceService();

        String text = fileHandler.readFileToString(args[FILE_PATH_ARGUMENT_POSITION]);
        String filePath = args[FILE_PATH_ARGUMENT_POSITION];


        switch (args[COMMAND_ARGUMENT_POSITION]) {
            case "ENCRYPT":
                fileHandler.writeStringToFile(filePath, encryptService.encrypt(text, Integer.parseInt(args[2])), "ENCRYPT");
                System.out.println("Successfully encrypted");
                break;

            case "DECRYPT":
                fileHandler.writeStringToFile(filePath, decryptService.decrypt(text, -Integer.parseInt(args[2])), "DECRYPT");
                System.out.println("Successfully decrypted");
                break;

            case "BRUTE_FORCE":
                fileHandler.writeStringToFile(filePath, bruteForceService.bruteForceDecrypt(text), "BRUTE_FORCE");
                System.out.println("Successfully brute forced");

        }

    }

    public void execute(String[] args, String command, String path) {
        InputValidation inputValidation = new InputValidation();
        inputValidation.validate(args, command, path);

        FileHandler fileHandler = new FileHandler();
        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        BruteForceService bruteForceService = new BruteForceService();

        String text = fileHandler.readFileToString(args[FILE_PATH_ARGUMENT_POSITION]);
        String filePath = args[FILE_PATH_ARGUMENT_POSITION];

        if (args[COMMAND_ARGUMENT_POSITION].equals("BRUTE_FORCE")) {
            fileHandler.writeStringToFile(filePath, bruteForceService.bruteForceDecrypt(text), "BRUTE_FORCE");
            System.out.println("Successfully brute forced");
        } else {
            throw new InvalidArgumentException("For arguments ENCRYPT, DECRYPT you need to set a key (shift)");
        }
    }
}
