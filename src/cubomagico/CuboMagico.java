package cubomagico;


//Alunos:   Lavyk Soares Nunes
//          Medson Lucius

public class CuboMagico {

    //Define uma cor para cada inteiro
    public static final int laranja = 0;
    public static final int azul = 1;
    public static final int amarelo = 2;
    public static final int branco = 3;
    public static final int vermelho = 4;
    public static final int verde = 5;

    int[] face = new int[54];

    public int getCor(int face) {
        int cor = this.face[face];
        return cor;
    }

    public CuboMagico() {
        reset();
    }

    //Ver cor de cada face
    public void getFace() {
        for (int i = 0; i < face.length; i++) {
            System.out.println("Face_" + i + ": " + face[i]);
        }
    }

    public void reset() {

        //Volta o cubo ao estado inicial
        for (int i = 0; i < 9; i++) {
            face[i] = laranja;
        }
        for (int i = 9; i < 18; i++) {
            face[i] = azul;
        }
        for (int i = 18; i < 27; i++) {
            face[i] = amarelo;
        }
        for (int i = 27; i < 36; i++) {
            face[i] = branco;
        }
        for (int i = 36; i < 45; i++) {
            face[i] = vermelho;
        }
        for (int i = 45; i < 54; i++) {
            face[i] = verde;
        }
    }

    //Verifica se o cubo está montado
    public boolean estaMontado() {

        //Verifica para cada face inicial de cada lado do cubo
        for (int i = 0; i < face.length; i = i + 9) {
            //Se 1 das 8 subsequentes faces for de cor diferente da primeira face de cada cor retorna false [não está montado]
            if (!(face[i] == face[i + 1] && face[i] == face[i + 2] && face[i] == face[i + 3] && face[i] == face[i + 4] && face[i] == face[i + 5] && face[i] == face[i + 6] && face[i] == face[i + 7] && face[i] == face[i + 8])) {
                return false;
            }
        }
        return true;
    }

    //Movimentos
    private final int[][] mov1F = {{18, 19, 20}, {9, 12, 15}, {29, 28, 27}};
    private final int[][] mov2F = {{42, 39, 36}, {18, 19, 20}, {9, 12, 15}};
    private final int[][] mov3F = {{29, 28, 27}, {42, 39, 36}, {18, 19, 20}};
    private final int[][] mov4F = {{9, 12, 15}, {29, 28, 27}, {42, 39, 36}};

    private final int[][] mov1R = {{8, 5, 2}, {20, 23, 26}, {47, 50, 53}};
    private final int[][] mov2R = {{20, 23, 26}, {47, 50, 53}, {35, 32, 29}};
    private final int[][] mov3R = {{47, 50, 53}, {35, 32, 29}, {8, 5, 2}};
    private final int[][] mov4R = {{35, 65, 29}, {8, 5, 2}, {20, 23, 26}};

    private final int[][] mov1U = {{45, 46, 47}, {11, 10, 9}, {2, 1, 0}};
    private final int[][] mov2U = {{11, 10, 9}, {2, 1, 0}, {36, 37, 38}};
    private final int[][] mov3U = {{2, 1, 0}, {36, 37, 38}, {45, 46, 47}};
    private final int[][] mov4U = {{36, 37, 38}, {45, 46, 47}, {11, 10, 9}};

    private final int[][] mov1B = {{17, 14, 11}, {26, 25, 24}, {38, 41, 44}};
    private final int[][] mov2B = {{26, 25, 24}, {38, 41, 44}, {33, 34, 35}};
    private final int[][] mov3B = {{38, 41, 44}, {33, 34, 35}, {17, 14, 11}};
    private final int[][] mov4B = {{33, 34, 35}, {17, 14, 11}, {26, 25, 24}};

    private final int[][] mov1D = {{6, 7, 8}, {15, 16, 17}, {53, 52, 51}};
    private final int[][] mov2D = {{15, 16, 17}, {53, 52, 51}, {44, 43, 42}};
    private final int[][] mov3D = {{53, 52, 51}, {44, 43, 42}, {6, 7, 8}};
    private final int[][] mov4D = {{44, 43, 42}, {6, 7, 8}, {15, 16, 17}};

    private final int[][] mov1L = {{24, 21, 18}, {0, 3, 6}, {27, 30, 33}};
    private final int[][] mov2L = {{0, 3, 6}, {27, 30, 33}, {51, 48, 45}};
    private final int[][] mov3L = {{27, 30, 33}, {51, 48, 45}, {24, 21, 18}};
    private final int[][] mov4L = {{51, 48, 45}, {24, 21, 18}, {0, 3, 6}};

    //Sentido horario
    public void F() {
        boolean sentido = true;
        mover(mov1F, mov2F, mov3F, mov4F, sentido);
    }

    public void R() {
        boolean sentido = false;
        mover(mov1R, mov2R, mov3R, mov4R, sentido);
    }

    public void U() {

        boolean sentido = false;
        mover(mov1U, mov2U, mov3U, mov4U, sentido);
    }

    public void B() {
        boolean sentido = true;
        mover(mov1B, mov2B, mov3B, mov4B, sentido);
    }

    public void D() {
        boolean sentido = true;
        mover(mov1D, mov2D, mov3D, mov4D, sentido);
    }

    public void L() {
        boolean sentido = false;
        mover(mov1L, mov2L, mov3L, mov4L, sentido);
    }

    //Sentudo anti-horario
    public void f() {
        boolean sentido = false;
        mover(mov1F, mov2F, mov3F, mov4F, sentido);
    }

    public void r() {
        boolean sentido = true;
        mover(mov1R, mov2R, mov3R, mov4R, sentido);
    }

    public void u() {
        boolean sentido = true;
        mover(mov1U, mov2U, mov3U, mov4U, sentido);
    }

    public void b() {
        boolean sentido = false;
        mover(mov1B, mov2B, mov3B, mov4B, sentido);
    }

    public void d() {
        boolean sentido = false;
        mover(mov1D, mov2D, mov3D, mov4D, sentido);
    }

    public void l() {

        boolean sentido = true;
        mover(mov1L, mov2L, mov3L, mov4L, sentido);
    }

    //Metodo para mover as faces
    protected void mover(int[][] movA, int[][] movB, int[][] movC, int[][] movD, boolean sentido) {

        int[] aCores = new int[4];
        int[] bCores = new int[4];
        int[] cCores = new int[4];
        int[] dCores = new int[4];

        for (int cont = 0; cont < 3; cont++) {
            aCores[cont] = face[movA[1][cont]];
            bCores[cont] = face[movB[1][cont]];
            cCores[cont] = face[movC[1][cont]];
            dCores[cont] = face[movD[1][cont]];

        }

        if (!sentido) {

            for (int cont = 0; cont < 3; cont++) {

                face[movA[1][cont]] = dCores[cont];
                face[movB[1][cont]] = aCores[cont];
                face[movC[1][cont]] = bCores[cont];
                face[movD[1][cont]] = cCores[cont];

            }

        } else {
            for (int cont = 0; cont < 3; cont++) {

                face[movA[1][cont]] = bCores[cont];
                face[movB[1][cont]] = cCores[cont];
                face[movC[1][cont]] = dCores[cont];
                face[movD[1][cont]] = aCores[cont];

            }
        }
    }

    /*Ver o cubo, pode ignorar
    public void verCubo() {

        System.out.println("      +-----+");
        System.out.println("      |" + face[24] + " " + face[25] + " " + face[26] + "|");
        System.out.println("      |" + face[21] + " " + face[22] + " " + face[23] + "|");
        System.out.println("      |" + face[18] + " " + face[19] + " " + face[20] + "|");
        System.out.println("+-----+-----+-----+");
        System.out.println("|" + face[38] + " " + face[37] + " " + face[36] + "|" + face[0] + " " + face[1] + " " + face[2] + "|" + face[9] + " " + face[10] + " " + face[11] + "|");
        System.out.println("|" + face[41] + " " + face[40] + " " + face[39] + "|" + face[3] + " " + face[4] + " " + face[5] + "|" + face[12] + " " + face[13] + " " + face[14] + "|");
        System.out.println("|" + face[44] + " " + face[43] + " " + face[42] + "|" + face[6] + " " + face[7] + " " + face[8] + "|" + face[15] + " " + face[16] + " " + face[17] + "|");
        System.out.println("+-----+-----+-----+");
        System.out.println("      |" + face[27] + " " + face[28] + " " + face[29] + "|");
        System.out.println("      |" + face[30] + " " + face[31] + " " + face[32] + "|");
        System.out.println("      |" + face[33] + " " + face[34] + " " + face[35] + "|");
        System.out.println("      +-----+");
        System.out.println("      |" + face[51] + " " + face[52] + " " + face[53] + "|");
        System.out.println("      |" + face[48] + " " + face[49] + " " + face[50] + "|");
        System.out.println("      |" + face[45] + " " + face[46] + " " + face[47] + "|");
        System.out.println("      +-----+");

    }*/
}
