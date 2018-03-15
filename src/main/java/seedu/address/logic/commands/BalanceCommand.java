package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.money.Money;
import seedu.address.model.person.Person;

public class BalanceCommand extends Command {

    public static final String COMMAND_WORD = "balance";
    public static final String COMMAND_SHORTCUT = "b";

    public static final String MESSAGE_SUCCESS = "Shown balance.";

    public static double calculatedBalance;

    @Override
    public CommandResult execute() {

        double accumulator = 0.0;

        List<Person> lastShownList = model.getFilteredPersonList();


        for (Person person : lastShownList) {
            double currentPersonBalance = person.getMoney().balance;
            accumulator = accumulator + currentPersonBalance;
        }
        calculatedBalance = accumulator;
        System.out.println(accumulator);
        return new CommandResult("Your balance is " + Double.toString(calculatedBalance) + ".");
    }
}
