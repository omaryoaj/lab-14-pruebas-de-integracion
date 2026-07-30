package pe.edu.tecsup_cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios.
 */
public class UserRegistrationService {

    /**
     * Longitud mínima permitida para la contraseña.
     */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Almacena el último mensaje de error registrado.
     */
    private String lastErrorMessage = "";

    /**
     * Lista de usuarios registrados.
     */
    private List<String> users = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public UserRegistrationService() {
        System.out.println("Constructor llamado");
    }


    /**
     * Registra un nuevo usuario en la plataforma.
     *
     * @param username Nombre del usuario a registrar.
     * @param password Contraseña del usuario.
     * @param email Correo electrónico del usuario.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean registerUser(final String username,
                                final String password,
                                final String email) {
        if (username == null || username.trim().isEmpty()) {
            this.lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            this.lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            this.lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            this.lastErrorMessage = "El correo electrónico no parece válido.";
            return false;
        }

        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            this.lastErrorMessage = "Error desconocido al guardar el usuario.";
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Simula el guardado del usuario en la base de datos.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @param email Correo del usuario.
     * @throws Exception Si ocurre un error al guardar.
     */
    private void saveUser(final String username,
                          final String password,
                          final String email) throws Exception {
        this.users.add(username);
        if ("error".equals(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Obtiene la longitud de una cadena de texto.
     *
     * @param s Cadena de texto a evaluar.
     * @return La longitud de la cadena o -1 si es nula.
     */
    public final int x(final String s) {
        if (s == null) {
            return -1;
        }
        return s.length();
    }

    /**
     * Obtiene el último mensaje de error.
     *
     * @return Mensaje de error almacenado.
     */
    public String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

}