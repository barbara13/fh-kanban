package edu.fh.kanban.dao;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
		
	/**
	 * 
	 * @author Barbara
	 *
	 */
	
	public class Export extends JFrame{
		private static final long serialVersionUID = 1L;

	    public Export(){
			
	    	String path = System.getProperty("user.home");

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
	        	if(chooser.getFileFilter().getDescription().equals("CSV")){
	        		path = chooser.getSelectedFile().toString() + ".csv";
	        		new ExportBoardToCsv(path);
	        	}else if(chooser.getFileFilter().getDescription().equals("PDF")){
	        		path = chooser.getSelectedFile().toString() + ".pdf";
	        		new ExportBoardToPdf(path);
	        	}else if(chooser.getFileFilter().getDescription().equals("HTML")){
	        		path = chooser.getSelectedFile().toString() + ".html";
	        	}
	            chooser.setVisible(false);
	        }
	        chooser.setVisible(false);
	    }
	}