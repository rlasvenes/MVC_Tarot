package utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

public class MyLogger extends SecurityManager {

	private static FileHandler 	fh;
	private static final DateFormat df = new SimpleDateFormat("(dd/MM/yyyy) | HH:mm:ss.SSS");
	
	public MyLogger(String className) throws SecurityException, IOException {}
	
	public static Logger getLogger() throws SecurityException, IOException
    {
        String className = new MyLogger(MyLogger.class.getName()).getClassName();
        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);
        
        try {
        	// peut renvoyer une exception si il y a un problème lors de la création/ouverture du fichier .log
			fh = new FileHandler("logs/" + className + ".log");
			
			// format d'affichage sur une ligne seulement, dans un fichier texte
			fh.setFormatter(new SimpleFormatter() {
				public String format(LogRecord record) {
					return record.getLevel() + " : ["
							+ record.getSourceClassName() + "] ["
							+ record.getSourceMethodName() + "] -:- "
							+ "[" + df.format(record.getMillis()) + "] : " 
							+ record.getMessage() + "\n";
				}
			});
			logger.addHandler(fh);
		} catch (IOException ioe) {
			// on affiche les indications de notre exception
			JOptionPane.showMessageDialog(null, ioe.getMessage());
		}
        
        return logger;
    }

	// source : http://stackoverflow.com/questions/80692/java-logger-that-automatically-determines-callers-class-name
	// pour pouvoir avoir le nom de la classe appelant le Logger
	// ex: dans une classe A, Logger l = MyLogger.getLogger() 
	// produiras le fichier: subPackageA.A.log
    private String getClassName()
    {
        return getClassContext()[2].getName();
    }
}
