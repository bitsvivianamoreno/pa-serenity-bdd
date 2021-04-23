package core.actions;


import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import core.user_interface.StringComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenUrl;


/**
 * En esta clase se implementa la tarea navegar a una url
 */

public class OpenUrlAction implements ICommand<Task> {

private ICommand<String> url;

public OpenUrlAction(){
    url = new StringComponent();

}

    @Override
    public Task Execute(IParam params){
        GeneralParams param = (GeneralParams)params;
        return Task.where(param.where, new OpenUrl(url.Execute(params)));

    }
}
