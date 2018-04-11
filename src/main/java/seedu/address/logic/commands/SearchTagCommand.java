package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

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
    public static final String MESSAGE_SUCCESS = "Found Persons with tags: ";


    private final Set<Tag> tagsToFind;
    private List<Person> personsWithSpecifiedTags;
    private boolean changed = false;

    /**
     * This returns a SearchTagCommand that is ready to be executed.
     * @param tags  that need to be colored
     */
    public SearchTagCommand(Set<Tag> tags) {
        this.tagsToFind = tags;
    }
    @Override
    public CommandResult executeUndoableCommand() {

      /* List<Person> lastShownList = model.getFilteredPersonList();
        for (Person person : lastShownList) {
           for (Tag tag : person.getTags()) {
               if (tagsToFind.contains(tag)) {
                   changed = true;
                   System.out.println(person.getName());
               }
           }
        }*/

        model.updateFilteredPersonList(personHasTags());
        if (model.getFilteredPersonList().size() > 0) {
            return new CommandResult(MESSAGE_SUCCESS
                    + "\n"
                    + tagsToFind.toString()
                    + "\n"
                    + getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
        } else {
            return new CommandResult("No results found.");
        }
    }

    public Predicate<Person> personHasTags() {
        return person -> person.getTags().containsAll(tagsToFind);
    }

}






