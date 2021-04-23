package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.IParam;
import core.Helpers.ICommand;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

/**
 *En esta clase se genera la accion de dar clic
 * @version 1.0
 */

public class ClickButtonAction implements ICommand<Task> {

    /**
     * Se crea una variable de tipo IComand nombrada _target
     */
    private ICommand<Target> _target;

    /**
     * Se genera el constructor de la clase e inicializa la variable _target
     */
    public ClickButtonAction()
    {
        _target = new TargetComponent();
    }

    /**
     * Se genera el metodo encargado de ejecutar la tarea dar click
     * @param params guarda la informacion del elemento
     * @return retorna la accion de dar clic sobre un elemento
     */
    @Override
    public Task Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;
        return Task.where(param.where, Click.on(_target.Execute(params)));
    }
}
