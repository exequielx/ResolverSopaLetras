package parcialbactraking;

public class ParcialBactraking {

    private char matrizSopaDeLetras[][]
            = {{'F', 'L', 'O', 'R', 'E', 'C', 'E', 'X', 'P', 'K', 'A', 'N', 'M', 'H', 'L'},
            {'G', 'W', 'P', 'S', 'M', 'B', 'B', 'F', 'S', 'V', 'D', 'A', 'S', 'E', 'B'},
            {'Y', 'R', 'J', 'Ù', 'J', 'A', 'O', 'D', 'W', 'A', 'O', 'O', 'M', 'R', 'C'},
            {'K', 'Q', 'A', 'L', 'Z', 'K', 'R', 'Á', 'M', 'C', 'R', 'S', 'A', 'M', 'E'},
            {'A', 'E', 'C', 'C', 'G', 'C', 'V', 'A', 'U', 'A', 'A', 'O', 'D', 'O', 'T'},
            {'Y', 'F', 'U', 'Z', 'I', 'I', 'U', 'I', 'V', 'C', 'R', 'Z', 'R', 'S', 'F'},
            {'U', 'V', 'I', 'N', 'D', 'A', 'I', 'I', 'M', 'I', 'F', 'B', 'E', 'A', 'A'},
            {'D', 'I', 'D', 'I', 'O', 'E', 'S', 'Z', 'L', 'O', 'L', 'Ñ', 'H', 'S', 'M'},
            {'A', 'C', 'A', 'Ñ', 'F', 'V', 'D', 'A', 'H', 'N', 'O', 'L', 'N', 'Ñ', 'I'},
            {'N', 'L', 'R', 'O', 'K', 'M', 'I', 'N', 'É', 'E', 'J', 'E', 'O', 'W', 'L'},
            {'T', 'W', 'A', 'S', 'I', 'C', 'O', 'O', 'R', 'S', 'B', 'É', 'Í', 'S', 'I'},
            {'E', 'V', 'K', 'Ú', 'E', 'S', 'C', 'E', 'L', 'E', 'B', 'R', 'A', 'N', 'A'},
            {'L', 'V', 'C', 'P', 'M', 'Q', 'E', 'M', 'E', 'J', 'O', 'R', 'P', 'R', 'U'},
            {'R', 'M', 'S', 'Z', 'P', 'R', 'E', 'S', 'E', 'N', 'T', 'E', 'Ñ', 'R', 'A'},
            {'B', 'E', 'K', 'W', 'A', 'K', 'O', 'B', 'S', 'E', 'Q', 'U', 'I', 'O', 'S'}};

    public static void main(String[] args) {
        new ParcialBactraking();
    }

    public ParcialBactraking() {
        buscarCandidato(0, 0, "ESPECIAL");
    }

    private void buscarCandidato(int x, int y, String palabra) {
        if (x < matrizSopaDeLetras[0].length) {
            if (y < matrizSopaDeLetras.length) {
                if (palabra.charAt(0) == matrizSopaDeLetras[x][y]) {
                    recorrer(x, y, palabra, 0, 0);
                    String resultado = imprirResultado(x, y, palabra);
                    if (!resultado.equals("vacio")) {
                        System.out.println(resultado);
                        return;
                    }
                }
                buscarCandidato(x, y + 1, palabra);
            } else {
                buscarCandidato(x + 1, 0, palabra);
            }
        }
    }

    String vertivalDecendente = "";
    String verticalAcendente = "";
    String horizontalDecendente = "";
    String horizontalAcendente = "";
    String diagonalDecendente = "";
    String diagonalAcendente = "";
    String transversalDecendente = "";
    String transversalAcendente = "";

    private void recorrer(int x, int y, String comparacion, int m, int i) {
        if (m < comparacion.length()) {
            if (i < matrizSopaDeLetras.length) {

                if (x + i < matrizSopaDeLetras.length) {
                    vertivalDecendente += matrizSopaDeLetras[x + i][y];
                }
                if (x - i >= 0) {
                    verticalAcendente += matrizSopaDeLetras[x - i][y];
                }
                if (y + i < matrizSopaDeLetras[0].length) {
                    horizontalDecendente += matrizSopaDeLetras[x][y + i];
                }
                if (y - i >= 0) {
                    horizontalAcendente += matrizSopaDeLetras[x][y - i];
                }
                if (x + i < matrizSopaDeLetras.length && y + i < matrizSopaDeLetras[0].length) {
                    diagonalDecendente += matrizSopaDeLetras[x + i][y + i];
                }
                if (x - i >= 0 && y - i > 0) {
                    diagonalAcendente += matrizSopaDeLetras[x - i][y - i];
                }
                if (x - i >= 0 && y + i < matrizSopaDeLetras[0].length) {
                    transversalDecendente += matrizSopaDeLetras[x - i][y + i];
                }
                if (y - i >= 0 && x + i < matrizSopaDeLetras.length) {
                    transversalAcendente += matrizSopaDeLetras[x + i][y - i];
                }
                recorrer(x, y, comparacion, m, i + 1);
            } else {
                recorrer(x, y, comparacion, m + 1, 0);
            }
        }
    }

    private String imprirResultado(int x, int y, String comparacion) {
        if (vertivalDecendente.contains(comparacion)) {
            return ("Si encontro en verticar decreciente: " + x + "," + y);
        }

        if (verticalAcendente.contains(comparacion)) {
            return ("Si encontro en verticar Acendente: " + x + "," + y);
        }

        if (horizontalDecendente.contains(comparacion)) {
            return ("Si encontro en horizontal decreciente: " + x + "," + y);
        }

        if (horizontalAcendente.contains(comparacion)) {
            return ("Si encontro en horizontal Acendente: " + x + "," + y);
        }

        if (diagonalAcendente.contains(comparacion)) {
            return ("Si encontro en diagonal Acendente: " + x + "," + y);
        }

        if (diagonalDecendente.contains(comparacion)) {
            return ("Si encontro en diagonal Decendente: " + x + "," + y);
        }

        if (transversalAcendente.contains(comparacion)) {
            return ("Si encontro en transversal Acendente: " + x + "," + y);
        }

        if (transversalDecendente.contains(comparacion)) {
            return ("Si encontro en transversal Decendente: " + x + "," + y);
        }
        return "vacio";
    }

}
