package core.Helpers;

/**
 * se crea la interfaz IComand que contiene un metodo Execute que recibe un parametro
 * @param <T> variable necesaria para la ejecucion del metodo
 */
public interface ICommand<T> {
    T Execute(IParam params);
}
