package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class SearchTagCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "searchtag";
    public static final String COMMAND_SHORTCUT = "st";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": finds all the people having the specified tag"
            + PREFIX_TAG + "TAG...\n"
            + "Example: " + COMMAND_WORD
            + PREFIX_TAG + "owesMoney "
            + PREFIX_TAG + "friends";


    private final Set<Tag> tagsToFind;

    private boolean changed = false;

    /**
     * This returns a ColorTagCommand that is ready to be executed.
     *
     * @param tags  that need to be colored
     */
    public SearchTagCommand(Set<Tag> tags) {
        this.tagsToFind = tags;
    }
    //Method attempts to change the color of all tags to a specified color.
    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        for (Person person : lastShownList) {
           for (Tag tag : person.getTags()) {
               if (tagsToFind.contains(tag)) {
                   changed = true;
               }
           }
        }
        if (changed) {
            return new CommandResult("Tags Changed.");
        } else {
            changed = false;
            return new CommandResult("No tags found");
        }
    }

}






