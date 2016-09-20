package restaurant.formObjects;

public class HomepageForm {
    private String inputField;

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String inputField) {
        this.inputField = inputField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomepageForm that = (HomepageForm) o;

        return inputField != null ? inputField.equals(that.inputField) : that.inputField == null;

    }

    @Override
    public int hashCode() {
        return inputField != null ? inputField.hashCode() : 0;
    }
}
