import IO.FileHandler;
import exception.InvalidArgumentException;
import managers.ProgramManager;
import service.BruteForceService;
import service.DecryptService;
import service.EncryptService;
import util.InputValidation;


public class Main {

    private static final int COMMAND_ARGUMENT_POSITION = 0;
    private static final int FILE_PATH_ARGUMENT_POSITION = 1;
    private static final int KEY_ARGUMENT_POSITION = 2;

    public static void main(String[] args) {

        ProgramManager programManager = new ProgramManager();
        if (args.length == 3) {
            programManager.execute(args, args[COMMAND_ARGUMENT_POSITION], args[FILE_PATH_ARGUMENT_POSITION], args[KEY_ARGUMENT_POSITION]);
        } else {
            programManager.execute(args, args[COMMAND_ARGUMENT_POSITION], args[FILE_PATH_ARGUMENT_POSITION]);
        }


    }
}