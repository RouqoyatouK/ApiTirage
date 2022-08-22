package com.tirage.freetirage.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.Model.Postulant;
import com.tirage.freetirage.repository.PostulantRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService {
 
	
	final private PostulantRepo postulant;

    PostulantServiceImpl(PostulantRepo postulant) {
        this.postulant = postulant;
    }
	
	//@Override
	public List<Postulant> importerFichier(MultipartFile file) {
		// TODO Auto-generated method stub
		List<Postulant> listeAretoune=new ArrayList<>();
		
        List<String> values = new ArrayList<String>();

        try {

            InputStream input = new FileInputStream("Classeur1.xls");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()){
                values.clear();
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next();

                    if( cell.getCellType() == CellType.NUMERIC)
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                    else if (CellType.STRING == cell.getCellType())
                    values.add(cell.getStringCellValue());
                }

                listeAretoune.add(new Postulant(null, values.get(0), values.get(1), values.get(2), values.get(3), null));
                //postulant.InsertPostulant(values.get(0), values.get(1), values.get(2), values.get(3));
            }
            
            return listeAretoune ;
            

        } catch (IOException e) {
        	
            
            return null;
        }
    }

		
	

	@Override
	public List<Postulant> Lire() {
		// TODO Auto-generated method stub
		return postulant.findAll();
	}

	@Override
	public Postulant Ajouter(Postulant p) {
		// TODO Auto-generated method stub
		return postulant.save(p);
	}

}
