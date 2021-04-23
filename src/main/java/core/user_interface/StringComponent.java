package core.user_interface;

import core.Helpers.GeneralParams;
import core.Helpers.ICommand;
import core.Helpers.IParam;


public class StringComponent implements ICommand<String> {

    @Override
    public String Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;
        return String.format(param.url);
    }
}
