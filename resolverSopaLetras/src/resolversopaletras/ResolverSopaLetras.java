package resolversopaletras;

/**
 *
 * @author exequielx
 */
public class ResolverSopaLetras {

    private char matriz[][]
            = {{'F', 'L', 'O', 'R', 'E', 'C', 'E', 'X', 'P', 'K', 'A', 'N', 'M', 'H', 'L'},
            {'G', 'W', 'P', 'S', 'M', 'B', 'B', 'F', 'S', 'V', 'D', 'A', 'S', 'E', 'B'},
            {'Y', 'R', 'J', 'Ù', 'L', 'A', 'O', 'D', 'W', 'A', 'O', 'O', 'M', 'R', 'C'},
            {'K', 'Q', 'A', 'L', 'Z', 'E', 'R', 'Á', 'M', 'C', 'R', 'S', 'A', 'M', 'E'},
            {'A', 'E', 'C', 'C', 'G', 'C', 'I', 'A', 'U', 'A', 'A', 'O', 'D', 'O', 'T'},
            {'Y', 'F', 'U', 'Z', 'I', 'I', 'U', 'U', 'V', 'C', 'R', 'Z', 'R', 'S', 'F'},
            {'U', 'V', 'I', 'N', 'D', 'A', 'I', 'I', 'Q', 'I', 'F', 'B', 'E', 'A', 'A'},
            {'D', 'I', 'D', 'I', 'O', 'E', 'S', 'Z', 'L', 'E', 'L', 'Ñ', 'H', 'S', 'M'},
            {'A', 'C', 'A', 'Ñ', 'F', 'V', 'D', 'A', 'H', 'N', 'X', 'L', 'N', 'Ñ', 'I'},
            {'N', 'L', 'R', 'O', 'K', 'M', 'I', 'N', 'É', 'E', 'J', 'E', 'O', 'W', 'L'},
            {'T', 'W', 'A', 'S', 'I', 'C', 'O', 'O', 'R', 'S', 'B', 'É', 'Í', 'S', 'I'},
            {'E', 'V', 'K', 'Ú', 'E', 'S', 'C', 'E', 'L', 'E', 'B', 'R', 'A', 'N', 'A'},
            {'L', 'V', 'C', 'P', 'M', 'Q', 'E', 'M', 'E', 'J', 'O', 'R', 'P', 'R', 'U'},
            {'R', 'M', 'S', 'Z', 'P', 'R', 'E', 'S', 'E', 'N', 'T', 'E', 'Ñ', 'R', 'A'},
            {'B', 'E', 'K', 'W', 'A', 'K', 'O', 'B', 'S', 'E', 'Q', 'U', 'I', 'O', 'S'}};

    public static void main(String[] args) {
        new ResolverSopaLetras();
    }

    public ResolverSopaLetras() {
        palabra = palabra.toUpperCase();
        resolver();
    }
    private String palabra = "exequiel";

    private void resolver() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (palabra.charAt(0) == matriz[i][j]) {
                    for (int k = 0; k <= 7; k++) {
                        buscar(i, j, palabra.substring(0, 1), k, "");
                        if (encontrada) {
                            break;
                        }
                    }
                }
                if (encontrada) {
                    break;
                }
            }
            if (encontrada) {
                break;
            }
        }
    }
    private boolean encontrada = false;

    private void buscar(int i, int j, String formada, int direccion, String historico) {
        historico += (i + 1) + ":" + (j + 1) + "-";
        i = getI(i, direccion);
        j = getJ(j, direccion);

        formada += matriz[i][j];

        if (palabra.contains(formada)) {
            if (palabra.equals(formada)) {
                historico += (i + 1) + ":" + (j + 1) + "-";
                encontrada = true;
                imprimir(historico.substring(0, historico.length() - 1));
                return;
            }

            buscar(i, j, formada, direccion, historico);
        }
    }

    private int getI(int i, int direccion) {
        if (direccion == 0 || direccion == 4) {
            return i;
        }
        if (direccion == 1 || direccion == 2 || direccion == 3) {
            if (i == matriz.length - 1) {
                return i;
            } else {
                return i + 1;
            }
        }
        if (direccion == 5 || direccion == 6 || direccion == 7) {
            if (i == 0) {
                return i;
            } else {
                return i - 1;
            }
        }
        throw new UnsupportedOperationException("error");
    }

    private int getJ(int j, int direccion) {
        if (direccion == 7 || direccion == 0 || direccion == 1) {
            if (j == 0) {
                return j;
            } else {
                return j - 1;
            }
        }
        if (direccion == 2 || direccion == 6) {
            return j;
        }
        if (direccion == 3 || direccion == 4 || direccion == 5) {
            if (j == matriz[0].length - 1) {
                return j;
            } else {
                return j + 1;
            }
        }
        throw new UnsupportedOperationException("error");
    }

    private void imprimir(String historico) {
        System.out.println(historico);
    }

}
