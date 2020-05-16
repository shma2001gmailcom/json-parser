package org.misha.domain;

public enum Status {
    NEW("new"),
    IN_PROGRESS("in progress"),
    DONE("done");
    private final String text;

    Status(final String text) {
        this.text = text;
    }

    public static Status fromText(String text) {
        for (Status status : Status.values()) {
            if (status.text.equals(text)) {
                return status;
            }
        }
        throw new RuntimeException("Incorrect text for status: " + text);
    }
//    modern variant of the same stuff
//    public static Status fromText(String text) {
//        return Stream.of(Status.values())
//                     .filter(value -> value.text.equals(text))
//                     .findFirst().orElseThrow(RuntimeException::new);
//    }

    @Override
    public String toString() {
        return text;
    }
}
