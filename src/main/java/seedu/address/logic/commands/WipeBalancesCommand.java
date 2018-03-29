package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.money.Money;
import seedu.address.model.person.Person;

import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

/**
 * Handles the balance command.
 */
public class WipeBalancesCommand extends Command {

    public static final String COMMAND_WORD = "wipe";
    public static final String COMMAND_SHORTCUT = "w";
    public static final String MESSAGE_SUCCESS = "Wiped all balances";
    public static final String MESSAGE_USAGE = COMMAND_WORD + "Wipes all balances";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private Money cleared = new Money("0.0");
    @Override
    public CommandResult execute() throws CommandException {
        Person oldPerson;
        try {
            for (Person p : model.getFilteredPersonList()) {
                oldPerson = p;
                p.setMoney(cleared);
                model.updatePerson(oldPerson, p);
            }
        } catch (DuplicatePersonException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        } catch (PersonNotFoundException pnfe) {
            throw new AssertionError("The target person cannot be missing");
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
