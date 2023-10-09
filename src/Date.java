public class Date {

    // Data Fields
    private final int dia;
    private final int mes;
    private final int ano;

    // Constructors
    public Date(int dia, int mes, int ano) {
        if (!dataValida(dia, mes, ano))
            throw new IllegalArgumentException("Invalid date! :(");
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Date(String dataStr) {
        String[] parts = dataStr.split("-");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format! Use dd-mm-yyyy");
        }

        int dia = Integer.parseInt(parts[0]);
        int mes = Integer.parseInt(parts[1]);
        int ano = Integer.parseInt(parts[2]);

        if (!dataValida(dia, mes, ano)) {
            throw new IllegalArgumentException("Invalid date! :(");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }


    //Methods

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Methods
    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", dia, mes, ano);
    }

    private boolean dataValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12)
            return false;
        if (ano < 0)
            return false;
        if (dia < 1 || dia > nrDiasMes())
            return false;
        return true;
    }

    private int nrDiasMes() {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.mes == 2 && anoBissexto()) {
            return 29;
        }
        return diasPorMes[mes];
    }
    private boolean anoBissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public Date diaSeguinte() {
        int novoDia = dia + 1;
        int novoMes = mes;
        int novoAno = ano;

        if (novoDia > nrDiasMes()) {
            novoDia = 1;
            novoMes++;
            if (novoMes > 12) {
                novoMes = 1;
                novoAno++;
            }
        }

        return new Date(novoDia, novoMes, novoAno);
    }
}
