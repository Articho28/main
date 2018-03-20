package seedu.address.logic.commands;

import java.util.List;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.core.index.Index;

import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.model.person.Person;

/**
 * Finds the person to which you owe the most money
 */
public class MinCommand extends Command {

    public static final String COMMAND_WORD = "min";
    public static final String COMMAND_SHORTCUT = "mn";
    public static final String MESSAGE_SUCCESS = "The contact to which you owe the most money is: ";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds the person to which you owe the most money ";

    @Override
    public CommandResult execute() {
        List<Person> lastShownList = model.getFilteredPersonList();
        Index index = Index.fromZeroBased(0);
        double lowestDebt = lastShownList.get(0).getMoney().balance;

        for (int i = 0; i < lastShownList.size(); i++) {
            Person person = lastShownList.get(i);
            if (person.getMoney().balance < lowestDebt) {
                index = Index.fromZeroBased(i);
                lowestDebt = person.getMoney().balance;
            }
        }

        EventsCenter.getInstance().post(new JumpToListRequestEvent(index));
        return new CommandResult(MESSAGE_SUCCESS + lastShownList.get(index.getZeroBased()).getName());
    }
}
