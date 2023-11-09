package main;

public class input {
    private String optionChoice;

    public void setOptionChoice(String optionChoice){
        if(optionChoice != null && optionChoice.matches("\\d{1}")){
            this.optionChoice = optionChoice;
        }
        else{
            throw new IllegalArgumentException("\n !!!!!!!!!! You have Entered Wrong Value !!!!!!!!!!\n");
        }
    }

    public String getOptionChoice() {
        return optionChoice;
    }
}
