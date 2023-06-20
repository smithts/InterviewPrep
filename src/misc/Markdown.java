package misc;

public class Markdown {

    /**
     * Method to translate a string into valid markdown
     *
     * @param markdown: string to be translated
     *
     * @return line of valid markdown
     * */
    public String parse(String markdown) {
        // Validate that input is not null
        if (markdown == null) {
            throw new UnsupportedOperationException("Data input is invalid. Must not be null.");
        }

        // Breakup input into segments based on new line characters for processing
        String[] lines = markdown.split(Constants.NEW_LINE);

        StringBuilder resultBuilder = new StringBuilder();

        //Instantiating here to reduce excessive memory usage from repeatedly creating objects.
        String line;
        StringBuilder lineBuilder;

        // Process all input segments
        for (int i = 0; i < lines.length; i++) {

            line = lines[i]; // grab current line

            lineBuilder = new StringBuilder(); // create new StringBuilder for this current line

            if (!line.isBlank()) { //if line is blank, we'll ignore it
                // Process each line based on how that line begins
                if (Character.isLetter(line.charAt(0)) || line.startsWith("_")) {
                    // this is a paragraph, potentially with italics and bolds within it
                    lineBuilder.append(Constants.PARAGRAPH_OPEN)
                            .append(processItalicAndBold(line))
                            .append(Constants.PARAGRAPH_CLOSED);

                } else if (line.startsWith("#")) {
                    // this is a header
                    lineBuilder.append(processHeader(line));

                } else if (line.startsWith("*")) {
                    // this line is the beginning of an unordered list
                    lineBuilder.append(Constants.UL_OPEN);

                    // process all possible list items.
                    while (line.startsWith("*")) {
                        lineBuilder.append(processUnorderedList(line)); //process current list line

                        i++; //increment to next line
                        if (i >= lines.length) {
                            // we have reached the end of the input, and must break
                            break;
                        } else {
                            // set new line, and process again
                            line = lines[i];
                        }
                    }

                    i--; // move index back one for further processing
                    lineBuilder.append(Constants.UL_CLOSED);
                }
            }

            // Append result from processing the current line
            resultBuilder.append(lineBuilder);
        }

        // return the string builder to the client
        return resultBuilder.toString();
    }

    /**
     * Helper method to process an unordered list line item
     *
     * @param line of input
     *
     * @return line processed as a markdown line item
     * */
    private String processUnorderedList(String line) {
        return Constants.LI_OPEN
                + processItalicAndBold(line.substring(2))
                + Constants.LI_CLOSED;
    }

    /**
     * Helper method to process a header line
     *
     * @param line of input
     *
     * @return line processed as a markdown header
     * */
    private String processHeader(String line) {
        // Split the string based on spaces to get each individual segment
        String[] headerSegments = line.split(Constants.SPACE);
        int headerLength = headerSegments[0].length();

        // removed preceeding hashes from string
        line = line.substring(headerLength + 1);

        return "<h"+headerLength+">"
                + line
                + "</h"+headerLength+">";
    }

    /**
     * Helper method to process a line that may contain italics and bolds
     *
     * @param line of input
     *
     * @return line processed as a markdown line with potential italics and bolds
     * */
    private String processItalicAndBold(String line) {
        // Split the string based on spaces to get each individual segment
        String[] lineSegments = line.split(Constants.SPACE);
        StringBuilder resultBuilder = new StringBuilder();

        for (String currentSegment : lineSegments) {
            if(currentSegment.startsWith(Constants.DOUBLE_UNDER)) {
                // prepend with bold tag and remove underscores
                currentSegment = Constants.STRONG_OPEN + currentSegment.substring(2);
            }

            if (currentSegment.endsWith(Constants.DOUBLE_UNDER)) {
                // append closing bold tag and remove underscores
                currentSegment = currentSegment.substring(0, currentSegment.length() - 2) + Constants.STRONG_CLOSED;
            }

            if (currentSegment.startsWith(Constants.UNDER)) {
                // prepend with italics tag and remove underscore
                currentSegment = Constants.ITAL_OPEN + currentSegment.substring(1);
            }

            if (currentSegment.endsWith(Constants.UNDER)) {
                // append with italics tag and remove underscore
                currentSegment = currentSegment.substring(0, currentSegment.length() - 1) + Constants.ITAL_CLOSED;
            }

            // append current segment onto result and add a space
            resultBuilder.append(currentSegment)
                    .append(Constants.SPACE);
        }

        // return trimmed string
        return resultBuilder.toString().trim();
    }

}

