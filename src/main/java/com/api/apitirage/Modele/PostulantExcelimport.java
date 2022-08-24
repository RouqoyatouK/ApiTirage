package com.api.apitirage.Modele;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostulantExcelimport {

    public List<Postulant> excelImport(MultipartFile file)
    {
        //definition d'une liste de type postulant pour stocker les postulant trié
        List <Postulant> postulantList = new ArrayList<>();

        String nom="";
        String prenom="";
        String numero="";
        String email="";

        //l'heure de debut de l'importation
        long start = System.currentTimeMillis();

        try {
            //FileInputStream inputStrean = new FileInputStream(file.getInputStream());

            //ouverture du fichier excel uploader
            Workbook workbook = new XSSFWorkbook(file.getInputStream());

            //permet de recuperer la première feuille du fichier
            Sheet firstSheet=workbook.getSheetAt(0);

            //on definit la liste rowIterator de type Row qui va contenir toutes les lignes du fichier
            Iterator<Row> rowIterator=firstSheet.iterator();

            rowIterator.next();

            //On va parcourir la feuille ligne par ligne tant qu-il y'a une ligne suivante
            while (rowIterator.hasNext()){

                //la méthode next() renvoie l'élément suivant et passe également à l'élément suivant.
                Row nextRow = rowIterator.next();

                Iterator<Cell> cellIterator = nextRow.cellIterator();


                //on parcours les cellules
                while (cellIterator.hasNext()){


                    //la méthode next() renvoie la cellule suivant et passe également à la cellule suivante.
                    Cell nextCell=cellIterator.next();

                    //Renvoie l'index de base zéro pour le nom de colonne donné, ou -1 si la colonne n'existe pas.
                    int columnIndex = nextCell.getColumnIndex();

                    //verifie les valeurs de columnIndex
                    switch (columnIndex){

                        //si ça vaut 0
                        case 0:
                            //On recuoere le nom du postulant
                            nom=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(nom);
                            break;
                        //si ça vaut 1
                        case 1:
                            //On recuoere le prenom du postulant
                            prenom=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(prenom);
                            break;

                        //si ça vaut 2
                        case 2:
                            //On recuoere le numero du postulant
                            numero=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(numero);
                            break;

                        //si ça vaut 3
                        case 3:
                            //On recuoere le email du postulant
                            email=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(email);
                            break;
                    }
                    //postulantList.add(new Postulant(nom_postulant, prenom_postulant, numero_postulant, email_postulant));
                }
                postulantList.add(new Postulant(nom, prenom, numero, email));

            }

            //permet de fermer le fichier
            workbook.close();

            //l'heure de fin de limportation
            long end = System.currentTimeMillis();

            //affichage de l'heure du debut  et fin de l'importation
            System.out.printf("Import done in %d ms\n", (end - start));

        }
        //lorsqu'il y a une exception comme le fichier not found
        catch (Exception e) {
            e.printStackTrace();
        }

        return  postulantList;//retourne de la liste des postulant importé
    }
}
