package TP;

public class atuendoNivelAltoCommand implements Command {
    private SugeridorDeAtuendos sugeridor;

    public atuendoNivelAltoCommand (SugeridorDeAtuendos sugeridor) {
        this.sugeridor = sugeridor;
    }

    @Override
    public void execute() {
        this.sugeridor.capasAUtilizar.add(1);
        this.sugeridor.capasAUtilizar.add(2);
        this.sugeridor.categorias.add("superior");
        this.sugeridor.categorias.add("accesorio");
    }

}