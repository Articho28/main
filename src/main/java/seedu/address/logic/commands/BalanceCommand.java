package seedu.address.logic.commands;

import java.util.List;
import java.text.DecimalFormat;
import seedu.address.model.person.Person;

public class BalanceCommand extends Command {

    public static final String COMMAND_WORD = "balance";
    public static final String COMMAND_SHORTCUT = "b";
    private static DecimalFormat FORMAT_TWO_DECIMAL_PLACES = new DecimalFormat("0.00");

    public static final String MESSAGE_SUCCESS = "Shown balance.";

    public static double calculatedBalance;

    @Override
    public CommandResult execute() {

        double accumulator = 0.00;

        List<Person> lastShownList = model.getFilteredPersonList();


        for (Person person : lastShownList) {
            double currentPersonBalance = person.getMoney().balance;
            accumulator = accumulator + currentPersonBalance;
        }
        calculatedBalance = accumulator;


        return new CommandResult("Your balance is " + FORMAT_TWO_DECIMAL_PLACES.format(calculatedBalance) + ".");
    }
}
