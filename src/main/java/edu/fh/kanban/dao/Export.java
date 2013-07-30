package edu.fh.kanban.dao;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.DocumentException;
		
	/**
	 * 
	 * @author Barbara
	 *
	 */
	
	public class Export extends JFrame{
		
		private static final long serialVersionUID = 1L;
		private File file;

	    public Export(){
			
	    	String path = System.getProperty("user.home");
//	        this.file = new File(path.trim());

	    	JFileChooser chooser = new JFileChooser(path);
	        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
	        FileNameExtensionFilter csv = new FileNameExtensionFilter("CSV", ".csv");
	        FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF", ".pdf");
	        FileNameExtensionFilter html = new FileNameExtensionFilter("HTML", ".html");
	        	 		
	        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
	        chooser.setFileFilter(csv);
	        chooser.setFileFilter(pdf);
	        chooser.setFileFilter(html);
	        chooser.setVisible(true);

	        int result = chooser.showSaveDialog(this);

	        if (result == JFileChooser.APPROVE_OPTION) {

	           path = chooser.getSelectedFile().toString();

	            chooser.setVisible(false);
	        }
//	        this.file = new File(path);
	        chooser.setVisible(false);
	        
	        new TestPdfErstellen(path);
	        
	    }
	    public File getFile() {
	    	return this.file;
	    }
	    
	}