package block2.lesson6.Work3;

public class Greeter {
    private Formality formality = Formality.none;

    public String greet() {
        return switch (this.formality) {
            case formal -> "Good evening, sir.";
            case casual -> "Sup bro?";
            case intimate -> "Hello Darling!";
            case none -> "Hello";
        };
    }

    public void setFormality(Formality formality) {
        this.formality = formality;
    }
}
