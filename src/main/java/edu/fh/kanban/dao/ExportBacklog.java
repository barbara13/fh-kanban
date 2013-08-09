package edu.fh.kanban.dao;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportBacklog extends JFrame {

	/**
	 * @author Maxim
	 * Der Backlog kann als Pdf oder csv gespeichert werden
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	
	public ExportBacklog(){
		path = System.getProperty("user.home");

    	JFileChooser chooser = new JFileChooser(path);
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        FileNameExtensionFilter csv = new FileNameExtensionFilter("CSV", ".csv");
        FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF", ".pdf");
        	 		
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        chooser.setFileFilter(csv);
        chooser.setFileFilter(pdf);
        chooser.setVisible(true);

        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
        	if(chooser.getFileFilter().getDescription().equals("CSV")){
        		path = chooser.getSelectedFile().toString() + ".csv";
        		new ExportBacklogToCsv(path);
        	}else if(chooser.getFileFilter().getDescription().equals("PDF")){
        		path = chooser.getSelectedFile().toString() + ".pdf";
        		new ExportBacklogToPdf(path);
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
