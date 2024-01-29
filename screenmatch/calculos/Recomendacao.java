package screenmatch.calculos;

public class Recomendacao {
    public void filtrar(Classificavel classificavel) {
        if (classificavel.getClassicao() >= 4) {
            System.out.println("Extase dos criticos");
        } else if (classificavel.getClassicao() >= 2) {
            System.out.println("Um filme muito bem avaliado");
        } else {
            System.out.println("Salve já na sua lista");
        }

    }
}
