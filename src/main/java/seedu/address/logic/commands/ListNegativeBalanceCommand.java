package seedu.address.logic.commands;

import java.util.function.Predicate;

import seedu.address.model.person.Person;

/**
 * Lists all persons with negative balances in the address book to the user.
 */
public class ListNegativeBalanceCommand extends Command {

    public static final String COMMAND_WORD = "list negative";
    public static final String COMMAND_SHORTCUT = "ln";

    public static final String MESSAGE_SUCCESS = "Listed all persons with negative balance amounts";

    @Override
    public CommandResult execute() {

        model.updateFilteredPersonList(isNegativeBalance());
        return new CommandResult(MESSAGE_SUCCESS);
    }
    public Predicate<Person> isNegativeBalance() {
        return p -> p.getMoney().balance < 0;
    }
}
