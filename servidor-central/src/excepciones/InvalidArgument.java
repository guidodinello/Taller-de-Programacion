package excepciones;

@SuppressWarnings("serial")
public class InvalidArgument extends Exception {

    public InvalidArgument(String string) {
        super(string);
    }
}