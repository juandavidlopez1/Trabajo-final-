
import controller.ControllerUser;

public class Main {
    public static void main(String[] args) {
        
        ControllerUser postRequest = new ControllerUser("POST", "http://localhost:8080/api/users", "Content-Type: application/json", "Juan David,jdlopez@gmail.com,123456789");

        // Ejemplo de una solicitud GET para obtener todos los usuarios
        ControllerUser getRequest = new ControllerUser("GET", "http://localhost:8080/api/users", "HeaderInfo", "");

        // Ejemplo de una solicitud GET para obtener un usuario por ID
        ControllerUser getRequestById = new ControllerUser("GET", "http://localhost:8080/api/users", "HeaderInfo", "", 1);

        // Ejemplo de una solicitud PUT para actualizar un usuario
        ControllerUser putRequest = new ControllerUser("PUT", "http://localhost:8080/api/users", "Content-Type: application/json", "Juan David,Jdlz@gmail.com,987654321", 2);

        // Ejemplo de una solicitud DELETE para eliminar un usuario
        ControllerUser deleteRequest = new ControllerUser("DELETE", "http://localhost:8080/api/users", "HeaderInfo", "", 1);
    }
}
