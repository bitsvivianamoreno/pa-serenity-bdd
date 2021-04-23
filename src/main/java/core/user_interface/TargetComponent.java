package core.user_interface;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;
import net.serenitybdd.screenplay.targets.Target;

public class TargetComponent implements ICommand<Target> {

    @Override
    public Target Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;
        return Target.the(param.targetElementName).locatedBy(param.cssOrXPathSelector);
    }

}
