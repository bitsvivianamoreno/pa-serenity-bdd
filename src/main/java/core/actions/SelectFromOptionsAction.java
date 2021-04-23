package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromOptionsAction implements ICommand<Task> {

    private String value;
    private ICommand<Target> _target;

    public SelectFromOptionsAction(String value) {
        this.value = value;
        _target = new TargetComponent();
    }

    @Override
    public Task Execute(IParam params) {
        GeneralParams param = (GeneralParams) params;

        return Task.where(param.where, SelectFromOptions.byVisibleText(this.value).from(_target.Execute(params)));
    }
}
