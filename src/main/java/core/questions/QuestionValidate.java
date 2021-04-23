package core.questions;

import core.Helpers.*;
import core.Helpers.ICommand;
import core.user_interface.TargetComponent;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *En esta clase se genera la accion de validar una etiqueta
 * @version 1.0
 */

public class QuestionValidate implements ICommand<Consequence> {

    /**
     * Se crea una variable de tipo String que almacena el texto a validar y una variable
     * IComand que almacena el identificador del elemento
     */
    private  ICommand<Target> _target;
    private String equalsToString;

    /**
     * Se genera el constructor de la clase donde recibe un parametro tipo String
     * <br>
     * @param equalsToString variable que almacena el texto a validar
     * <br>
     * inicializa la variable _target
     */
    public QuestionValidate(String equalsToString) {
        _target = new TargetComponent();
        this.equalsToString = equalsToString;
    }

    /**
     *Se genera el metodo encargado de ejecutar la question que valida una etiqueta
     *@param params guarda la informacion del elemento
     *@return retorna la validacion de un texto
     */
    @Override
    public Consequence Execute(IParam params) {
        GeneralParams param = (GeneralParams)params;

        Question<String> question = actor -> Text.of(_target.Execute(params))
                .viewedBy(actor).asString();

        return seeThat(param.targetElementName, question, equalTo(equalsToString));

    }

}
