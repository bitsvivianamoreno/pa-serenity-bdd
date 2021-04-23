package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

/**
 *En esta clase se genera la accion de hacer Scroll hacia un elemento
 * @version 1.0
 */

public class ScrollingAction implements ICommand<Task> {

    /**
     * Se crea una variable de tipo IComand nombrada _target
     */
    private ICommand<Target> _target;

    /**
     * Se genera el constructor de la clase e inicializa la variable _target
     */
    public  ScrollingAction(){
        _target = new TargetComponent();
    }

    /**
     * Se genera el metodo encargado de ejecutar la tarea hacer scroll
     * @param params guarda la informacion del elemento
     * @return retorna la accion de hacer scroll hacia un elemento
     */
    @Override
    public Task Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;
        return Task.where(param.where, Scroll.to(_target.Execute(params)));
    }
}
