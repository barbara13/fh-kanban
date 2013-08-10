package edu.fh.kanban.dao;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
		
	/**
	 * 
	 * @author Barbara
	 * Das Board kann als Pdf, csv oder html gespeichert werden
	 *
	 */
	public class ExportBoard extends JFrame{
		private static final long serialVersionUID = 1L;
		private String path;

	    public ExportBoard(){
	    	path = System.getProperty("user.home");

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
	        		new HTML().createHTML();
	        	}
	            chooser.setVisible(false);
	        }
	        chooser.setVisible(false);
	    }

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}