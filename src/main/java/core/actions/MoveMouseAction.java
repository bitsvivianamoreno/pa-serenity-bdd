package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;

public class MoveMouseAction implements ICommand<Task> {

    /**
     * Se crea una variable de tipo IComand nombrada _target
     */
    private ICommand<Target> _target;

    /**
     * Se genera el constructor de la clase e inicializa la variable _target
     */
    public MoveMouseAction()
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
        return Task.where(param.where, MoveMouse.to(_target.Execute(params)));
    }
}
