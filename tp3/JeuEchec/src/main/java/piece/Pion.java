/*
 * Copyright 2017 Jean-Michel Poirier et Audrey Eugene.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package piece;

/**
 *
 * @author jmppr
 */
public class Pion extends Piece {

    public Pion(String couleur, int row, int col) {
        super(couleur, row, col);
    }

    @Override
    public boolean estDeplacementValide(int row, int col) {
        boolean resultat = false;
        if (couleur.equals("Noir")) {
            if (this.row == 1) {
                if (this.col == col && (this.row + 1 == row || this.row + 2 == row)) {
                    resultat = true;
                }
            } else {
                if (this.col == col && this.row + 1 == row) {
                    resultat = true;
                }
            }
        } else if (couleur.equals("Blanc")) {
            if (this.row == 6) {
                if (this.col == col && (this.row - 1 == row || this.row - 2 == row)) {
                    resultat = true;
                }
            } else {
                if (this.col == col && this.row - 1 == row) {
                    resultat = true;
                }
            }
        }
        return resultat;
    }
}
