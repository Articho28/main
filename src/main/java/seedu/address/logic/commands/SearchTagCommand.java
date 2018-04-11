//@@author Articho28
package seedu.address.logic.commands;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.function.Predicate;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class SearchTagCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "searchtag";
    public static final String COMMAND_SHORTCUT = "st";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": finds all the people having the specified tags. "
            + "Person must have all the provided tags to be selected. "
            + PREFIX_TAG + "TAG...\n"
            + "Example: " + COMMAND_WORD
            + PREFIX_TAG + "owesMoney "
            + PREFIX_TAG + "friends";

    public static final String MESSAGE_SUCCESS = "Found Persons with tags: ";


    private final Set<Tag> tagsToFind;

    /**
     * This returns a SearchTagCommand that is ready to be executed.
     * @param tags  that need to be colored
     */
    public SearchTagCommand(Set<Tag> tags) {
        this.tagsToFind = tags;
    }

    /**
     * This command lists all the persons which match the search criteria provided by the user.
     * @return
     */
    @Override
    public CommandResult executeUndoableCommand() {
        model.updateFilteredPersonList(personHasTags(tagsToFind));
        int result = model.getFilteredPersonList().size();
        if (result > 0) {
            String tagsFormatted = formatTagsFeedback(tagsToFind);
            return new CommandResult(MESSAGE_SUCCESS
                    + "\n"
                    + tagsFormatted
                    + "\n"
                    + getMessageForPersonListShownSummary(result));
        } else {
            return new CommandResult("No results found.");
        }
    }

    /**
     * This function returns person Predicate that indicates if a given has the tags we are
     * looking for.
     * @return
     */
    public static Predicate<Person> personHasTags(Set<Tag> tagsToCheck) {
        return person -> person.getTags().containsAll(tagsToCheck);
    }

    public static String formatTagsFeedback(Set<Tag> tagsToFormat) {
        String tagsFormatted = tagsToFormat.toString()
                .replace("[", " ")
                .replace("]", " ")
                .replace("[,", " ");
        return tagsFormatted;
    }
}






