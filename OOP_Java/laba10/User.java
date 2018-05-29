package laba10;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName = "no data";
    private String lastName = "no data";
    private String patronymic = "no data";
    private String birthday = "no data";
    private String height = "no data";
    private String eyeColor = "no data";
    private String specificMarks = "no data";
    private String enterDate = java.time.LocalDate.now().toString();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setSpecificMarks(String string) {
        this.specificMarks = string;
    }

    public String toString() {
        return "Реєстраційний номер:          " + firstName + '\n'
                + "Досвід роботи:                " + lastName + '\n'
                + "Освіта:                       " + patronymic + '\n'
                + "Дата звільнення:              " + birthday + '\n'
                + "Вимоги до майбутньої роботи:  " + eyeColor + '\n';
                //+ "Height:         " + height + '\n'
                //+ "Specific marks: " + specificMarks + '\n'
                //+ "Enter date:     " + enterDate + '\n';
    }
}
