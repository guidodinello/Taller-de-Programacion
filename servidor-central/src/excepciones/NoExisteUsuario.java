package excepciones;

@SuppressWarnings("serial")
public class NoExisteUsuario extends Exception {

    public NoExisteUsuario(String string) {
        super(string);
    }
}