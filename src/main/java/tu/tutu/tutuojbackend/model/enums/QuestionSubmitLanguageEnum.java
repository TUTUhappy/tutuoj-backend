package tu.tutu.tutuojbackend.model.enums;




public enum QuestionSubmitLanguageEnum {

    JAVA("java", "java"),
    CPLUSPLUS("cpp", "cpp"),
    GOLANG("go", "go");

    private final String text;

    private final String value;

    QuestionSubmitLanguageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }



    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
