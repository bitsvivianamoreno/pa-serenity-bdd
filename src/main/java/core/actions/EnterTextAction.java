package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.IParam;
import core.Helpers.ICommand;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

/**
 *En esta clase se genera la accion de ingresar texto
 * @version 1.0
 */


public class EnterTextAction implements ICommand<Task> {

    /**
     * Se crea una variable de tipo String que almacena el valor a ingresar y una varible
     * IComand que almacena el identificador del elemento
     */
    private  String value;
    private ICommand<Target> _target;

    /**
     * Se genera el constructor de la clase donde recibe un parametro tipo String
     * <br>
     * @param value variable que almacena el valor a ingresar
     * <br>
     * inicializa la variable _target
     */
    public EnterTextAction(String value){
        this.value = value;
        _target = new TargetComponent();
    }

    /**
     *Se genera el metodo encargado de ejecutar la tarea ingresar texto
     *@param params guarda la informacion del elemento
     *@return retorna la accion de ingresar texto
     */
    @Override
    public Task Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;
        return Task.where(param.where, Enter.theValue(this.value).into(_target.Execute(params)));
    }
}
