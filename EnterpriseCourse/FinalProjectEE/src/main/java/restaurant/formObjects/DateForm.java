package restaurant.formObjects;

import java.util.Date;

public class DateForm {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateForm dateForm = (DateForm) o;

        return date != null ? date.equals(dateForm.date) : dateForm.date == null;

    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }
}
