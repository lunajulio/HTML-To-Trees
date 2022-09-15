int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de nodos"));
        int costo[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    costo[i][j] = 0;
                } else {
                        costo[i][j] = (int) (Math.random()*10);
                        costo[j][i] = costo[i][j];  
                }
                
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + ", " + j + "] = " + costo[i][j] +"  ");
            }
        }
