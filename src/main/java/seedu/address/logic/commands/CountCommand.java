package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Returns number of stored persons
 */
public class CountCommand extends Command {

    public static final String COMMAND_WORD = "count";

    public static final String MESSAGE_SUCCESS = "Number of persons: %1$s";

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getFilteredPersonList().size()));
    }
}
