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
package fichier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author jmppr
 */
public class EnregistrerFichier {

    private File fichier;

    public EnregistrerFichier(String nomFichier) {
        fichier = new File(nomFichier);

    }

    /**
     * Permet à l'utilisateur de choisir l'emplacement de l'enregistrement du
     * fichier.
     *
     * @param nomExtension Le nom de l'extension du fichier
     * @param extension l'extension du fichier
     * @return Le fichier
     */
    private void associerPathAuFichier(String nomExtension, String extension) {
        FileChooser fichierChoisie = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(nomExtension, extension);
        fichierChoisie.getExtensionFilters().add(extFilter);
        fichier = fichierChoisie.showSaveDialog(new Stage());
    }

    /**
     * Sauvegarde la chaine de caractere passé en paramètre dans un fichier
     *
     * @param contenu La chaine de caractère à sauvegarder
     * @param nomExtension Le nom de l'extension du fichier
     * @param extension l'extension du fichier
     */
    public void sauvegarderDansFichier(String contenu, String nomExtension, String extension) {
        associerPathAuFichier(nomExtension, extension);
        if (fichier != null) {
            ecrireDansFichier(contenu);
        }
    }

    public void sauvegarderDansFichier(String contenu) {
        ecrireDansFichier(contenu);
    }

    private void ecrireDansFichier(String contenu) {
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(fichier);
            fileWriter.write(contenu);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
