package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.FindResults;

/**
 * Tests that a {@code Person}'s {@code Major} matches any of the keywords given.
 */
public class MajorContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;
    private final String commandPrefix = "m/";

    public MajorContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> FindResults.getInstance()
                        .containsWordIgnoreCase(person.getMajor().value, keyword, commandPrefix)
                        || keywords.stream()
                            .anyMatch(fuzzyKeyword -> FindResults.getInstance().containsFuzzyMatchIgnoreCase(
                                person.getMajor().value, fuzzyKeyword, commandPrefix,
                                    FindCommand.LEVENSHTEIN_DISTANCE_THRESHOLD)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MajorContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((MajorContainsKeywordsPredicate) other).keywords)); // state check
    }

}
