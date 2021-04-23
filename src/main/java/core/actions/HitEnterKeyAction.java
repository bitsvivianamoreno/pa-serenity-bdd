package core.actions;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class HitEnterKeyAction implements ICommand<Task> {

    private ICommand<Target> _target = new TargetComponent();

    @Override
    public Task Execute(IParam params) {
        GeneralParams param = (GeneralParams) params;
        return Task.where(param.where, Hit.the(Keys.ENTER).into(_target.Execute(params)));
    }
}
